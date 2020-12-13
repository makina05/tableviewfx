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
        String query = "select t.target, s.string, t.target_id from targets t join scans s where s.string like 'Wordpress%' or s.string like 'Joomla%' or s.string like 'phpMyAdmin%' or s.string like 'Drupal%';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Laguntzailea> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String target = rs.getString("target");
                String target_id = rs.getString("target_id");
                String string = rs.getString("string").split(" ")[0];
                String version = rs.getString("string").split(" ")[1];

//                String sep1 = string.split(" ")[0];
//                String sep2 = string.split(" ")[1];

                Laguntzailea laguntzailea = new Laguntzailea(target,string,version,target_id);
                emaitza.add(laguntzailea);

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}