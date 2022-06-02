
package model;

import modeldatabase.Connector;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class MovieModel {
    public Connector DB;
    public MovieModel(Connector DB){
        this.DB = DB;
    }
    
    public Object[][] getMovie(){
        Object[][] movie = new Object[100][5];
        try{
            DB.statement = DB.conn.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `movie`");
            
            int i = 0;
            while(result.next()){
                movie[i][0] = result.getString("judul");
                movie[i][1] = result.getString("alur");
                movie[i][2] = result.getString("penokohan");
                movie[i][3] = result.getString("akting");
                movie[i][4] = result.getString("nilai");
                i++;
            }
            DB.statement.close();
        } catch(Exception err){
            System.out.println(err);
        }
        return movie;
    }
    
    public void insert(String judul, double alur, double penokohan, double akting){
        try {
            double rating = (alur+penokohan+akting)/3.0;
            DB.statement = DB.conn.createStatement(); 
            String query = "INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES ('"+judul+"', '"+alur+"', '"+penokohan+"', '"+akting+"', '"+rating+"')";
            DB.statement.execute(query);
        } catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void update(String judul, double alur, double penokohan, double akting){
        try {
            double rating = (alur+penokohan+akting)/3.0;
            DB.statement = DB.conn.createStatement(); 
            String query = "UPDATE `movie` SET `alur` = '"+alur+"', `penokohan` = '"+penokohan+"', `akting` = '"+akting+"', `nilai` = '" +rating+ "' WHERE `movie`.`judul` = '" +judul+ "'";
            DB.statement.execute(query);
            
        }  catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void delete(String judul){
        try {
            DB.statement = DB.conn.createStatement(); 
            String query = "DELETE FROM `movie` WHERE `movie`.`judul` = '"+judul+"'";
            DB.statement.execute(query);
            
        } catch(Exception err){
            System.out.println(err);
        }
    }
}
