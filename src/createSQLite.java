/**
 * Created by dremon on 09/11/15.
 */
import java.sql.*;

public class createSQLite {

    public static void main(String[] args) {

        crearTablas();


    }


    public static void crearTablas() {

        Connection c = null;
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

           /* stmt = c.createStatement();
            String sql = "CREATE TABLE PELICULAS " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " TITLE           CHAR(50)    NOT NULL, " +
                    " DATA_ESTRENA            DATE     NOT NULL, " +
                    " PERSONATGES        CHAR(255))";
            stmt.executeUpdate(sql);
            stmt.close();*/

            stmt2 = c.createStatement();
            String sql2 = "CREATE TABLE RELACION " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " ID_ACTOR           INT   NOT NULL, " +
                    " ID_PERSONAJE       INT   NOT NULL, " +
                    " ID_PELICULA        INT   NOT NULL) ";
            stmt2.executeUpdate(sql2);
            stmt2.close();

            stmt3 = c.createStatement();
            String sql3 = "CREATE TABLE ACTORES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           CHAR(50)    NOT NULL, " +
                    " DATE_OF_BIRTHDAY          DATE     NOT NULL) ";
            stmt3.executeUpdate(sql3);
            stmt3.close();


            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}