package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.*; No es buena opcion, porque trae a toda la artilleria de sql


public abstract class HISQLiteDataHelper {

    private static final String DBPathConnection = "jdbc:sqlite:DataBase//EXOBOT.sqlite";
    private static Connection conn = null;
    // protected SQLiteDataHelper(){}; 

   protected static synchronized Connection openConnection() throws Exception{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection); //me conecto a la base de datos
        } catch (SQLException e) {
            throw e; //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return conn;
    }


    protected static void closeConnection() throws Exception{
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                throw e;//new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
            }
    }

}