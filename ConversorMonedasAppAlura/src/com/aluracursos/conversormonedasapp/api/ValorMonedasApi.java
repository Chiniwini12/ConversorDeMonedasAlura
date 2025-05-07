package com.aluracursos.conversormonedasapp.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ValorMonedasApi {
    public Monedas obtenerTasas() throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/864cc5a74fd299bd0a4c5467/latest/USD");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        JsonObject objeto = gson.fromJson(json, JsonObject.class);
        JsonObject tasas = objeto.getAsJsonObject("conversion_rates");
        double usd = tasas.get("USD").getAsDouble();
        double ars = tasas.get("ARS").getAsDouble();
        double cop = tasas.get("COP").getAsDouble();
        double brl = tasas.get("BRL").getAsDouble();
        return new Monedas(usd,ars,cop,brl);

    }
}
