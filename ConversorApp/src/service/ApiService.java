package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/a5ccbd0197c7023749149488/pair/";

    private final HttpClient client;

    public ApiService() {
        this.client = HttpClient.newHttpClient();
    }

    public String consultarApi(String monedaBase, String monedaDestino) throws IOException, InterruptedException {
        String url = BASE_URL + monedaBase + "/" + monedaDestino;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
