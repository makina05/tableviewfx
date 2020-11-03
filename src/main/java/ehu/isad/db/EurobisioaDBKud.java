package ehu.isad.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EurobisioaDBKud {
    private static final EurobisioaDBKud instance = new EurobisioaDBKud();

    public static EurobisioaDBKud getInstance(){
        return instance;
    }

    private EurobisioaDBKud(){
        }

    public List<String> lortuHerrialdeak(){
        String query = "select izena from herrialde";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try{
            while (rs.next()){

                String izena = rs.getString("izena");

                System.out.println(izena);
                emaitza.add(izena);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}
