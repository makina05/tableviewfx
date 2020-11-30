package ehu.isad.db;

import ehu.isad.model.Laguntzailea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WhatWebDBKud {
    private static final WhatWebDBKud instance = new WhatWebDBKud();

    public static WhatWebDBKud getInstance(){
        return instance;
    }

    private WhatWebDBKud(){
        }

    public List<Laguntzailea> lortuOrrialdeak(){
        String query = "select t.target, s.version, s.string, t.target_id from targets t inner join scans s on t.target_id=s.target_id where string like 'Wordpress%' or 'Joombla%' or 'phpMyAdmin%' or 'Drupal%'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Laguntzailea> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String target = rs.getString("target");
                String version = rs.getString("version");
                String lastUp = rs.getString("target_id");
                String cms = rs.getString("string");
                Laguntzailea laguntzailea = new Laguntzailea(target,cms,version,lastUp);
                emaitza.add(laguntzailea);

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}
