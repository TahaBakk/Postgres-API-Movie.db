import java.sql.*;

/**
 * Created by x3727349s on 14/11/16.
 */
public class insertsSQLite {


    public static void insertPeliculas(String id, String title, String dataEstrena) {
        {
            Connection c = null;

            try {
                //Class.forName("org.sqlite.JDBC");
                //c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://172.31.73.195:5432/postgres","taha", "taha");
                System.out.println("Opened database successfully");

                String insert= "INSERT INTO PELICULAS" +
                        "(ID,TITLE,DATA_ESTRENA) VALUES" +
                        " (?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, dataEstrena);

                preparedStatement.executeUpdate();
                c.close();

            } catch (SQLException ex) {/*System.err.println(ex.getMessage())*/;
            } catch (ClassNotFoundException e) {/*e.printStackTrace();*/
            }
        }
        System.out.println("La pelicula a sido añadida a la tabla peliculas de la BBDD");
    }

    public static void insertActores(String id, String name, String dateabirthday) {
        {
            Connection c = null;

            try {
                //Class.forName("org.sqlite.JDBC");
                //c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://172.31.73.195:5432/postgres","taha", "taha");


                String insert= "INSERT INTO ACTORES" +
                        "(ID,NAME,DATE_OF_BIRTHDAY) VALUES" +
                        " (?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, dateabirthday);

                preparedStatement.executeUpdate();
                c.close();

            } catch (SQLException ex) {/*System.err.println(ex.getMessage())*/;
            } catch (ClassNotFoundException e) {/*e.printStackTrace();*/}
        }

        System.out.println("El actor a sido añadido a la tabla actores de la BBDD");
    }

    public static void insertRelacion(String id, String idActor, String idPelicula, String personaje) {
        {
            Connection c = null;

            try {
                //Class.forName("org.sqlite.JDBC");
                //c = DriverManager.getConnection("jdbc:sqlite:movies.db");
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://172.31.73.195:5432/postgres","taha", "taha");

                String insert= "INSERT INTO RELACION" +
                        "(ID,ID_ACTOR,ID_PELICULA,PERSONAJE) VALUES" +
                        " (?,?,?,?);";

                PreparedStatement preparedStatement = c.prepareStatement(insert);

                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.setInt(2, Integer.parseInt(idActor));
                preparedStatement.setInt(3, Integer.parseInt(idPelicula));
                preparedStatement.setString(4, personaje);

                preparedStatement.executeUpdate();
                c.close();


            } catch (SQLException ex) {/*System.err.println(ex.getMessage())*/;
            } catch (ClassNotFoundException e) {/*e.printStackTrace();*/}
        }
        System.out.println("Los datos han sido añadidos a la tabla relacion de la BBDD");
    }



















}
