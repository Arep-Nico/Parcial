package escuelaing.arep.parcial1;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * SparkWebApp
 */
public class SparkWebApp {

    /**
     * Funcion principal del proyecto
     * @param args argumentos de la clase
     */
    public static void main(String[] args) {
        int port = getPort();
        System.out.println("Listo para escuchar, puerto: " + port);
        port(port);
        get("/", (req, res) -> list(req, res));
    }

    private static String list(Request req, Response res) {

        System.out.println(req.body());

        ArrayList<String> sList = new ArrayList<String>( Arrays.asList(req.body().split("\\s*,\\s*")) );
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

        // mergeSort(dList, dList.size());

        for (Double double1 : dList) {
            System.out.println(double1);
        }
        
        return "hola";
    }

    private static <T extends Comparable<T>> void mergeSort(ArrayList<T> init, Integer n) {
        if (init.size() < 2)
            return;
        int mid = n/2;
        ArrayList<T> l = (ArrayList<T>) init.subList(0, mid);
        ArrayList<T> r = (ArrayList<T>) init.subList(mid, n);

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(init, l, r, mid, n - mid);
    }

    private static <T extends Comparable<T>> void merge(ArrayList<T> init, ArrayList<T> l, ArrayList<T> r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l.get(i).compareTo(r.get(j)) <= 0) {
                init.set(k++, l.get(i++));
            } else {
                init.set(k++, l.get(j++));
            }
        }

        while (i < left) {
            init.set(k++, l.get(i++));
        }
        while (j < right) {
            init.set(k++, r.get(j++));
        }
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