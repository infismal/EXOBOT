package DataAccess;

import java.sql.Connection;

//import java.sql.*; No es buena opcion, porque trae a toda la artilleria de sql


public abstract class SQLiteDataHelper {

    private static final String DBPathConnection = "jdbc:sqlite:DataBase//EXOBOT.sqlite";
    private static Connection conn = null;
    



}
