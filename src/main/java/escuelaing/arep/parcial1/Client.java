package escuelaing.arep.parcial1;

import java.io.*;
import java.net.*;
/**
 *
 * @author estudiante
 */
public class Client {
    
    public static void main(String[] args) throws Exception {
        /**
        * Lee la primera pagina del web server donde se insertarían los números        
        */
        URL url1 = new URL("https://obscure-beach-96504.herokuapp.com/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
        
        /**
        * Lee la segunda pagina del web server con un ejemplo de haber insertado la lista que contiene los números 1 2 3  
        */
        System.out.println("JSON RESULTADO:");
        URL url2 = new URL("https://obscure-beach-96504.herokuapp.com/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
       }
}
    
