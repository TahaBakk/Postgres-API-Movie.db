import java.sql.*;

/**
 * Created by x3727349s on 14/11/16.
 */
public class insertsSQLite {


    public static void insertPeliculas(String id, String title, String dataEstrena) {
        {
            Connection c = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                String insert= "INSERT INTO PELICULAS" +
                        "(ID,TITLE,DATA_ESTRENA) VALUES" +
                        " (?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, dataEstrena);

                preparedStatement.executeUpdate();


            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La pelicula a sido añadida a la tabla peliculas de la BBDD");
    }

    public static void insertActores(String id, String name, String dateabirthday) {
        {
            Connection c = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                String insert= "INSERT INTO ACTORES" +
                        "(ID,NAME,DATE_OF_BIRTHDAY) VALUES" +
                        " (?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, dateabirthday);

                preparedStatement.executeUpdate();


            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El actor a sido añadido a la tabla actores de la BBDD");
    }

    public static void insertRelacion(String id, String idActor, String idPelicula, String personaje) {
        {
            Connection c = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                String insert= "INSERT INTO RELACION" +
                        "(ID,ID_ACTOR,ID_PELICULA,PERSONAJE) VALUES" +
                        " (?,?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setString(1, id);
                preparedStatement.setString(2, idActor);
                preparedStatement.setString(3, idPelicula);
                preparedStatement.setString(4, personaje);

                preparedStatement.executeUpdate();


            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Los datos han sido añadidos a la tabla relacion de la BBDD");
    }



















}
