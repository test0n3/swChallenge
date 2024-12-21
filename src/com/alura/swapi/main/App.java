package com.alura.swapi.main;

import java.io.IOException;
import java.util.Scanner;

import com.alura.swapi.helper.FileGenerator;
import com.alura.swapi.models.Movie;

public class App {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Star Wars movie number: ");

        try {
            String input = userInput.nextLine();
            int movieNumber = Integer.parseInt(input);
            MovieSearch search = new MovieSearch();
            Movie movie = search.movieSearch(movieNumber);
            System.out.println("\n" + movie);
            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.saveRequest(movie);
        } catch (IOException e) {
            System.out.println("File can't be saved: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number not found, " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("\n" + e.getMessage());
        }

        System.out.println("Application ended successfully");
        userInput.close();
    }
}
