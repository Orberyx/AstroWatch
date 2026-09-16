package io.github.orberyx.astrowatch.nasa;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/*
* TODO:
*  - Adicionar exceções, como timeout;
*  - Adicionar as requisões;
*/

/*
 * OBS:
 * O trecho responsável pela formatação (pretty print) do JSON
 * foi escrito com auxílio de um agente generativo.
 */



public class NasaApiClient {
    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
    private static final String API_KEY = "kfBNR8RlArCpUlYtYUcXdogp9jWs8yksZxWilB3H";
    private static final String DEBUG_URL_PATH = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2026-09-04&end_date=2026-09-11&detailed=false&api_key=kfBNR8RlArCpUlYtYUcXdogp9jWs8yksZxWilB3H";
    
    
    public String buildUrl(LocalDate initialDate, LocalDate finalDate, boolean detailed) {
        String url = BASE_URL
                + "?start_date=" + initialDate
                + "&end_date=" + finalDate
                + "&detailed=" + detailed
                + "&api_key=" + API_KEY;

        return url;
    }
    
    public void apiCall() throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEBUG_URL_PATH))
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString()
        );
        
        // Código de formatação JSON gerado com auxílio de agente generativo.
        JsonElement json = JsonParser.parseString(response.body());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println(gson.toJson(json));
        
        //System.out.println(response.body());
        //return response;
        
    }

}    
