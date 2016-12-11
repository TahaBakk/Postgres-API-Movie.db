/**
 * Created by dremon on 09/11/15.
 */
import java.sql.*;

public class createSQLite {

    public static void crearTablas() {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE PELICULAS " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " TITLE           CHAR(50)    NOT NULL, " +
                    " DATA_ESTRENA            DATE     NOT NULL) ";

            String sql2 = "CREATE TABLE RELACION " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " ID_ACTOR           INT   NOT NULL, " +
                    " PERSONAJE       CHAR(100)   NOT NULL, " +
                    " ID_PELICULA        INT   NOT NULL) ";

            String sql3 = "CREATE TABLE ACTORES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           CHAR(50)    NOT NULL, " +
                    " DATE_OF_BIRTHDAY          DATE     NOT NULL) ";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}