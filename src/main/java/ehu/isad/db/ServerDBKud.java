package ehu.isad.db;

import ehu.isad.model.Lag2;
import ehu.isad.model.Laguntzailea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerDBKud {

    private static final ServerDBKud instance = new ServerDBKud();

    public static ServerDBKud getInstance(){
        return instance;
    }

    private ServerDBKud(){
    }

    public List<Lag2> lortuEskaneatutakoak(){
        String query = "select distinct t.target, s.string from targets t, scans s where s.string like '%Apache%' or '%NGINX%' or '%Node.js%' and s.string like '%(%'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Lag2> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String target = rs.getString("target");
                String server = rs.getString("string").split(" ")[0];
                String se = rs.getString("string").split(" ")[1];

                emaitza.add(new Lag2(target,server,se));

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
//    public List<Lag2> lortuServerra(){
//        String query = "select s.string from scans s where s.string like '%Apache%'";
//        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
//        ResultSet rs = dbKudeatzaile.execSQL(query);
//
//        List<Lag2> emaitza = new ArrayList<>();
//        try{
//            while (rs.next()){
//
//                String server = rs.getString("string");
//
//                emaitza.add(new Lag2(server));
//
//            }
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//        return emaitza;
//    }
}

