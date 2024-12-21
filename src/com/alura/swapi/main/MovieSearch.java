package com.alura.swapi.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.alura.swapi.models.Movie;
import com.google.gson.Gson;

public class MovieSearch {
  Movie movieSearch(int movieNumber) {
    URI address = URI.create("https://swapi.py4e.com/api/films/" + movieNumber + '/');
    // System.out.println("address:" + address);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(address)
        .build();

    HttpResponse<String> response = null;

    try {
      response = client.send(request, BodyHandlers.ofString());
      // System.out.println("response body: " + response.body());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    return new Gson().fromJson(response.body(), Movie.class);
  }
}
