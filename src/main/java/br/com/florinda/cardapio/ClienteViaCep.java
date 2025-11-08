package br.com.florinda.cardapio;



import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClienteViaCep {

    public static void main(String[] args) throws Exception {


        // Código na versão vaja 1.7
     /*
        URL url = new URL("https://viacep.com.br/ws/01001000/json/");
        Scanner scanner = null;
        try {
            scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } finally {
            if ( scanner != null){
                scanner.close();
            }
        }
    }
}
*/
        // No java 11

        URI uri = URI.create("https://viacep.com.br/ws/01001000/json/");

        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                                        HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String body = httpResponse.body();
            System.out.println(statusCode);
            System.out.println(body);


        }
    }
}