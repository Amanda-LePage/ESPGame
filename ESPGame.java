package espgame;

/*
 * Class: CMSC203 
 * Instructor: Professor Aygun
 * Description: This program tests the user's ESP (extrasensory perception) skills. The program randomly selects a color from a list of 16 colors, and the user tries to guess which color was selected. The program runs for three rounds and displays how many times the user guessed correctly. It also collects the user's name, a description of themselves, and the due date, displaying this information at the end of the game.
 * Due: 10/11/2024
 * Platform/compiler: Eclipse IDE, JavaSE-17
 * 
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Amanda Lepage
 */

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class ESPGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String filename = "colors.txt";  // File containing the colors
        
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        System.out.print("Enter the filename: ");
        System.out.println(filename);
        
        // Initialize color variables for file reading (max 16)
        int correctGuesses = 0;

        // Loop for 3 rounds
        for (int round = 1; round <= 3; round++) {
            System.out.println("\nRound " + round);
            System.out.println("I am thinking of a color.");
            System.out.println("Here is the list of colors:");

            // Read colors from the file and display them
            String selectedColor = null;
            try {
                Scanner fileScanner = new Scanner(new File(filename));
                int index = 1;
                while (fileScanner.hasNextLine()) {
                    String color = fileScanner.nextLine();
                    System.out.println(index + ": " + color.toLowerCase());  // Display color
                    index++;
                }
                fileScanner.close();

                // Select a random color after displaying the list
                fileScanner = new Scanner(new File(filename));
                int randomLine = random.nextInt(16) + 1; // 16 colors in total
                int lineCounter = 1;
                while (fileScanner.hasNextLine()) {
                    String color = fileScanner.nextLine();
                    if (lineCounter == randomLine) {
                        selectedColor = color;
                        break;  // Exit when the random color is found
                    }
                    lineCounter++;
                }
                fileScanner.close();

            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                return;
            }

            // User guess input
            System.out.print("Enter your guess: ");
            String userGuess = scanner.nextLine();

            // Check if the user's guess is correct
            if (userGuess.equalsIgnoreCase(selectedColor)) {
                System.out.println("I was thinking of " + selectedColor + ".");
                correctGuesses++;
            } else {
                System.out.println("I was thinking of " + selectedColor + ".");
            }
        }

        // Display total correct guesses
        System.out.println("\nGame Over");
        System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");

        // Collect student information
        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();

        System.out.print("Describe yourself: ");
        String studentDescription = scanner.nextLine();

        System.out.print("Due Date: ");
        String dueDate = scanner.nextLine();

        // Display student information
        System.out.println("\nYou guessed " + correctGuesses + " out of 3 colors correctly.");
        System.out.println("Enter your name: " + studentName);
        System.out.println("Describe yourself: " + studentDescription);
        System.out.println("Due Date: " + dueDate);

        // Display programmer's name
        System.out.println("\nProgrammed by: Amanda Lepage");

        // Close the scanner
        scanner.close();
    }
}
