package com.griffin.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {
    /*
    Read input from the console to add any number of integers, separated by spaces.
     */

    public static void main(String... args) {

        // Use Try with resources with Closeable resources
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            String[] splitString = input.split(" " );
            int sum = 0;
            for (String str: splitString) {
                sum += Integer.parseInt(str);
            }
            System.out.println("Sum: " + sum);
        } catch (IOException ioe) {

            // Log/process ioe here
            System.out.println("IOE: " +  ioe);

            // Process try w/resources exceptions
            Throwable[] throwables = ioe.getSuppressed();
            for (Throwable thrown: throwables) {
                System.out.println("Try/resource exception: " + thrown);
            }
        }
    }
}
