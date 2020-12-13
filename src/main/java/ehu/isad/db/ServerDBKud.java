package ehu.isad.db;

import ehu.isad.model.Lag2;
import ehu.isad.model.Laguntzailea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerDBKud {
    String server;
    String se;
    private static final ServerDBKud instance = new ServerDBKud();

    public static ServerDBKud getInstance(){
        return instance;
    }

    private ServerDBKud(){
    }

    public List<Lag2> lortuEskaneatutakoak(){
//eskaneatutako orrialde guztien izena, zerbitzaria eta OSa lortzeko eskaera
        String query = "select distinct t.target, s.string from targets t inner join scans s on t.target_id=s.target_id where s.string like '%nginx%' or s.string like '%Apache%' or s.string like '%Node.js%' and s.string like '%(%'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Lag2> emaitza = new ArrayList<>();
        try{
            while (rs.next()){
//Emaitzak era ezberdinetan agertzen direnez, splita ez du funtzionatzen baldin eta OSa aurkitu ez bada. Horregatik zenbait baldintza sortu ditugu
                String target = rs.getString("target");
                if (rs.getString("string").contains(" ")) { //zerbitzariaz aparte zeozer gehiago egon daiteke
                    if (rs.getString("string").split(" ")[0] == null) { //ez dakigu ezer
                        this.server = "Unknown";
                        this.se = "Unknown";
                    } else if (rs.getString("string").split(" ")[1] == null) { //zerbitzaria soilik dakigu
                        this.server = rs.getString("string").split(" ")[0];
                        this.se = "Unknown";
                    } else { //bai zerbitzaria bai OSa badakizkigu
                        this.server = rs.getString("string").split(" ")[0];
                        this.se = rs.getString("string").split(" ")[1];
                    }
                }
                else{ //zerbitzaria soilik agertzen da ezer gehiago gabe
                    this.server=rs.getString("string");
                    this.se = "Unknown";
                }

                emaitza.add(new Lag2(target,server,se));

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}

