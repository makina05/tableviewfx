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
        String query = "select t.target from targets t ";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Lag2> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String target = rs.getString("target");

                emaitza.add(new Lag2(target));

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}

