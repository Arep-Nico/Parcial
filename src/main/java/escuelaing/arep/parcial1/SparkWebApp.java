package escuelaing.arep.parcial1;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * SparkWebApp
 */
public class SparkWebApp {

    /**
     * Funcion principal del proyecto
     * 
     * @param args argumentos de la clase
     */
    public static void main(String[] args) {
        int port = getPort();
        System.out.println("Listo para escuchar, puerto: " + port);
        port(port);
        get("/", (req, res) -> list(req, res));
    }

    private static String list(Request req, Response res) {

        ArrayList<String> sList = new ArrayList<String>(Arrays.asList(req.body().split("\\s*,\\s*")));
        ArrayList<Double> dList = new ArrayList<>();
        for (String s : sList) {
            try {
                if (!s.equals(null)) {
                    Double parseNumber = Double.parseDouble(s);
                    dList.add(parseNumber);
                }
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
        Double sum = calculator(dList);
        mergeSort(dList, dList.size());

        ResponseClass<Double> resp = new ResponseClass<Double>(sum, dList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(resp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> init, Integer n) {

        if (n < 2)
            return;
        int mid = n/2;

        List<T> l = new ArrayList<T>();
        List<T> r = new ArrayList<T>();

        for (int i = 0; i < mid; i++) {
            l.add(init.get(i));
        }

        for (int i = mid; i < n; i++) {
            r.add(init.get(i));
        }


        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(init, l, r, mid, n - mid);
    }

    private static <T extends Comparable<T>> void merge(List<T> init, List<T> l, List<T> r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l.get(i).compareTo(r.get(j)) <= 0) {
                init.set(k++, l.get(i++));
            } else {
                init.set(k++, r.get(j++));
            }
        }

        while (i < left) {
            init.set(k++, l.get(i++));
        }
        while (j < right) {
            init.set(k++, r.get(j++));
        }
    }

    private static Double calculator(List<Double> init) {
        Double res = 0.0;
        for (Double t : init) {
            res += t;
        }
        return res;
    }

    /**
     * @return retorna un puerto disponible para correr la aplicacion
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}