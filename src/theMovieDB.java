import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by x3727349s on 14/11/16.
 */
public class theMovieDB {

    static Datos datos = new Datos();

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args){
        String s = "";
        String api_key = "82f0ce609a809c8375dc4061e7526935";

        //peliculasLlamada();
        //actoresLlamada();
        relacionLlamada();


    }
    public static void peliculasLlamada(){
        String s = "";
        String api_key = "82f0ce609a809c8375dc4061e7526935";
        for (int i = 0; i < 40; i++) {
            int peli = 600 +i;
            String film = String.valueOf(peli);
            String peticio = "https://api.themoviedb.org/3/movie/"+film+"?api_key="+api_key;
            try {
                s = getHTML(peticio);
                SJSPeli(s);
                //SJC(s);
            } catch (Exception e) {
                System.out.println("La peli "+film+" no existeix");
            }
        }
    }

    public static void actoresLlamada(){
        String s = "";
        String api_key = "82f0ce609a809c8375dc4061e7526935";
        for (int i = 0; i < 100; i++) {
            int actores = 600 +i;
            String actor = String.valueOf(actores);

            String peticio = "https://api.themoviedb.org/3/person/"+actor+"?api_key="+api_key;
            try {
                s = getHTML(peticio);
                SJSActor(s);
                //SJC(s);
            } catch (Exception e) {
                System.out.println("el actor "+actor+" no existeix");
            }
        }
    }

    public static void relacionLlamada(){
        String s = "";
        String api_key = "82f0ce609a809c8375dc4061e7526935";

        for (int i = 0; i < 40; i++) {
            int relaciones = 600 +i;
            String relacion = String.valueOf(relaciones);

            String peticio = "https://api.themoviedb.org/3/movie/"+relacion+"/credits?api_key="+api_key;
            try {
                s = getHTML(peticio);
                SJSRelacion(s);
                //SJC(s);
            } catch (Exception e) {
                System.out.println("La peli "+relacion+" no existeix");
            }
        }
    }



    public static void SJSPeli (String cadena){

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;

        datos.setIdPelicula(arra02.get("id").toString());
        datos.setTitlePelicula(arra02.get("original_title").toString());
        datos.setFechaEstrena(arra02.get("release_date").toString());

        //System.out.println(datos.getIdPelicula());
        //System.out.println(datos.getTitlePelicula());
        //System.out.println(datos.setFechaEstrena());

        //FALTA LLAMAR A LOS INSERTS
    }


    public static void SJSActor (String cadena){

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;

        datos.setIdActor(arra02.get("id").toString());
        datos.setNameActor(arra02.get("name").toString());
        datos.setDateBirthdayActor(arra02.get("birthday").toString());

        //System.out.println(datos.getIdActor());
        //System.out.println(datos.getNameActor());
        //System.out.println(datos.getDateBirthdayActor());

        //FALTA LLAMAR A LOS INSERTS
    }

    public static void SJSRelacion (String cadena){

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;

        JSONArray arra03 = (JSONArray)arra02.get("cast");

        for (int i = 0; i < arra03.size(); i++) {

            JSONObject arra04= (JSONObject)arra03.get(i);

            datos.setIdRelacion(arra04.get("cast_id").toString());
            datos.setIdPeliculaRelacion(arra02.get("id").toString());
            datos.setIdActorRelacion(arra04.get("id").toString());
            datos.setIdPersonajeRelacion(arra04.get("character").toString());

            System.out.println(datos.getIdRelacion());
            System.out.println(datos.getIdPeliculaRelacion());
            System.out.println(datos.getIdActorRelacion());
            System.out.println(datos.getIdPersonajeRelacion());




            //FALTA LLAMAR A LOS INSERTS

        }
    }








   /* public static void SJC (String cadena){
        Object obj02 =JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;
        JSONArray arra03 = (JSONArray)arra02.get("cast");


        for (int i = 0; i < arra03.size(); i++) {

            JSONObject jb= (JSONObject)arra03.get(i);
            System.out.println(jb.get("character")+"<-->"+jb.get("name"));

        }

    }*/

}
