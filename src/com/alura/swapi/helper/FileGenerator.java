package com.alura.swapi.helper;

import com.alura.swapi.models.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
  public void saveRequest(Movie movie) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    FileWriter writeFile = new FileWriter(movie.title() + ".json");
    writeFile.write(gson.toJson(movie));
    writeFile.close();
  }
}
