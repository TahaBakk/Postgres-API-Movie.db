import java.util.Scanner;

/**
 * Created by Taha on 11/12/2016.
 */
public class Main {

    public static void main(String[] args) {

        selectSQLite selects = new selectSQLite();
        createSQLite creates = new createSQLite();
        theMovieDB consultasApi = new theMovieDB();
        int num = 0;

        while(num != 9){
            System.out.println("Seleccione una de la opciones siguientes");
            System.out.println("------------------------------------------------");
            System.out.println("1.Ver los actores");
            System.out.println("2.Ver las peliculas");
            System.out.println("3.Ver la relacion entre actores y personajes");
            System.out.println("4.Ver los actores por el ID");
            System.out.println("5.Ver las peliculas por el ID");
            System.out.println("6.Ver la relacion entre actores y personajes por el ID");
            System.out.println("7.Crear tablas en la BBDD (en caso de existir las tablas no hara nada)");
            System.out.println("8.Bajar las peliculas entre otros datos de la API y hacer los inserts en las tablas corespodientes en la BBDD)");
            System.out.println("9.Salir");

            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            int numID=0;

            if (num == 4) {
                System.out.println("Introducce el ID del actor a buscar en la BBDD (en caso de no haver una coincidencia no devolvera nada)");
                numID=sc.nextInt();
                System.out.println("");
                }else if (num==5) {
                    System.out.println("Introducce el ID de la pelicula a buscar en la BBDD (en caso de no haver una coincidencia no devolvera nada)");
                    numID=sc.nextInt();

                    }else if (num==6) {
                        System.out.println("Introducce el ID de la relacion a buscar en la BBDD (en caso de no haver una coincidencia no devolvera nada)");
                        numID=sc.nextInt();

            }

            switch (num) {
                case  1: selects.selectActores();
                break;
                case  2: selects.selectPeliculas();
                break;
                case  3: selects.selectRelacion();;
                break;
                case  4: selects.selectActoresID(5);
                break;
                case  5: selects.selectPeliculasID(5);
                break;
                case  6: selects.selectRelacionID(5);
                break;
                case  7: creates.crearTablas();
                break;
                case  8: consultasApi.mainLlamadas();
                break;
                default:
                break;
            }
        }
    }
}
















