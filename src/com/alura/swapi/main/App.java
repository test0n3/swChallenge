package com.alura.swapi.main;

import java.util.Scanner;

import com.alura.swapi.models.Movie;

public class App {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a movie number: ");
        String input = userInput.nextLine();
        try {
            int movieNumber = Integer.parseInt(input);
            MovieSearch search = new MovieSearch();
            Movie movie = search.movieSearch(movieNumber);
            System.out.println("\n" + movie);
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid number input.");
        }

        userInput.close();
    }
}
