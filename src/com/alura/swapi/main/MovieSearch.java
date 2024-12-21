package com.alura.swapi.main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.alura.swapi.models.Movie;
import com.google.gson.Gson;

public class MovieSearch {
  public Movie movieSearch(int movieNumber) {
    URI address = URI.create("https://swapi.py4e.com/api/films/" + movieNumber + '/');

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(address)
        .build();

    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      return new Gson().fromJson(response.body(), Movie.class);
    } catch (Exception e) {
      throw new RuntimeException("Movie not found.");
    }
  }
}
