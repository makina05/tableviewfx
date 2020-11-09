package ehu.isad.db;

import ehu.isad.model.HerrialdeModel;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class EurobisioaDBKud {
    private static final EurobisioaDBKud instance = new EurobisioaDBKud();

    public static EurobisioaDBKud getInstance(){
        return instance;
    }

    private EurobisioaDBKud(){
        }
    public int getYear() {
        Calendar cal = Calendar.getInstance();
        return(cal.get(Calendar.YEAR));
    }
    public List<String> lortuHerrialdeak(){
        String query = "select izena from ParteHartzea where etorrikoDa='bai' and urtea=="+getYear();
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String izena = rs.getString("izena");
                emaitza.add(izena);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }

//    public List<String> lortuTopa(){
//        String query = "select izena, puntuak from Bozkaketa where izena=herrialdea and urtea=="+getYear()+"order by puntuak DESC limit 3";
//        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
//        ResultSet rs = dbKudeatzaile.execSQL(query);
//
//        List<String> emaitza = new ArrayList<>();
//        try{
//            while (rs.next()){
//
//                String izena = rs.getString("izena");
//                emaitza.add(izena);
//            }
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//        return emaitza;
//    }



}
