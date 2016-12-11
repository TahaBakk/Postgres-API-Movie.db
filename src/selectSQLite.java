import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Taha on 11/12/2016.
 */
public class selectSQLite {

    //Muestra todos los selects en la bbdd
    public void selectActores(){

    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:movies.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM ACTORES;" );
        while ( rs.next() ) {
            int id = rs.getInt("ID");
            String  name = rs.getString("NAME");
            String  date_of_birthday = rs.getString("DATE_OF_BIRTHDAY");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "ADDRESS = " + date_of_birthday );
            System.out.println();
        }
        rs.close();
        stmt.close();
        c.close();
    } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }
    System.out.println("Operation done successfully");
}

    public void selectPeliculas(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PELICULAS;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  name = rs.getString("TITLE");
                String  data_estrena = rs.getString("DATA_ESTRENA");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "ADDRESS = " + data_estrena );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void selectRelacion(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM RELACION;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  id_actor = rs.getString("ID_ACTOR");
                String  id_pelicula = rs.getString("ID_PELICULA");
                String  personaje= rs.getString("PERSONAJE");

                System.out.println("-----------------------------------");
                System.out.println( "ID = " + id );
                System.out.println( "ID actor = " + id_actor );
                System.out.println( "Personaje = " + personaje );
                System.out.println( "ID pelicula = " + id_pelicula );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }



    //Select por ID introducido a mano

    public void selectActoresID( int valorID){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ACTORES;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  name = rs.getString("NAME");
                String  date_of_birthday = rs.getString("DATE_OF_BIRTHDAY");

                //Si el ID introducido es igual al que imprimira lo imprime sino no hace nada
                if (id==valorID){
                System.out.println("-----------------------------------");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "ADDRESS = " + date_of_birthday );
                System.out.println("");}
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void selectRelacionID(int valorID){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM RELACION;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  id_actor = rs.getString("ID_ACTOR");
                String  id_pelicula = rs.getString("ID_PELICULA");
                String  personaje= rs.getString("PERSONAJE");

                if (id==valorID){
                System.out.println("-----------------------------------");
                System.out.println( "ID = " + id );
                System.out.println( "ID actor = " + id_actor );
                System.out.println( "Personaje = " + personaje );
                System.out.println( "ID pelicula = " + id_pelicula );
                System.out.println();}
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void selectPeliculasID(int valorID){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PELICULAS;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  name = rs.getString("TITLE");
                String  data_estrena = rs.getString("DATA_ESTRENA");

                if (id==valorID){
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "ADDRESS = " + data_estrena );
                System.out.println();}
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }


}




