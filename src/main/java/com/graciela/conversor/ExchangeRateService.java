package com.graciela.conversor;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateService {

    private static final String API_KEY = "fa9cbb7f08cc580ae6a911f3";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double obtenerTasa(String from, String to) {
        String url = BASE_URL + API_KEY + "/latest/" + from;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Respuesta HTTP no exitosa: " + response.statusCode());
            }

            String json = response.body();
            ExchangeRateResponse exchangeRateResponse = gson.fromJson(json, ExchangeRateResponse.class);

            if (!"success".equalsIgnoreCase(exchangeRateResponse.result)) {
                throw new RuntimeException("La API respondió con error: " + exchangeRateResponse.result);
            }

            Double tasa = exchangeRateResponse.conversionRates.get(to);
            if (tasa == null) {
                throw new RuntimeException("No se encontró tasa para la moneda destino: " + to);
            }

            return tasa;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al llamar a la API: " + e.getMessage(), e);
        }
    }

    private static class ExchangeRateResponse {
        String result;

        @SerializedName("conversion_rates")
        Map<String, Double> conversionRates;
    }
}
