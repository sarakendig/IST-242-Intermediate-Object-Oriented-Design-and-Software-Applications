package edu.psu.ist;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Collects information about a car then returns it to the user.
 */

public class Car {
    private static Scanner scanner = new Scanner(System.in); // scanner util from getting input from user

    /**
     * Prompts the user to enter the model of the car.
     *
     * @return The model of the car entered by the user.
     */

    public static String promptForModel() {
        System.out.print("Enter the model of the car: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter the release year of the car.
     *
     * @return The release year of the car entered by the user.
     */
    public static int promptForReleaseYear() {
        int year;
        while (true) {
            System.out.print("Enter the release year of the car: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year > 0) {
                    return year;
                } else {
                    System.out.println("Release year must be non-zero and non-negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year."); // if year is not valid it prompts user again
            }
        }
    }

    /**
     * Prompts the user to enter the car's trims.
     *
     * @return An ArrayList of car trims entered by the user.
     */
    public static ArrayList<String> promptForTrims() {
        ArrayList<String> trims = new ArrayList<>();
        while (true) {
            System.out.print("Enter a car trim (e.x. DX, LX, Sport) or press Enter to finish: ");
            String trim = scanner.nextLine();
            if (trim.isEmpty()) {       // if trim is empty it returns array
                return trims;
            }
            trims.add(trim);            // if trim is not empty, adds trim to array
        }
    }

    /**
     * Enum for the valid car types.
     */
    public enum CarType {
        Truck, Sedan, Coupe, StationWagon, Van
    }

    /**
     * Prompts user to enter the car type.
     *
     * @return The car type entered by the user.
     */
    public static CarType promptForCarType() {
        System.out.println("Acceptable car types: Truck, Sedan, Coupe, Station Wagon, Van");
        while (true) {
            System.out.print("Enter the car type: ");
            String carType = scanner.nextLine();
            try {
                return CarType.valueOf(carType);
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid car type.");   // if car type is invalid, prompts user
            }
        }
    }

    /**
     * Prompts the user to enter the car's MPG (miles per gallon).
     *
     * @return The MPG entered by the user.
     */
    public static double promptForMPG() {
        double mpg;
        while (true) {
            System.out.print("Enter the car's MPG: ");
            try {
                mpg = Double.parseDouble(scanner.nextLine());
                if (mpg >= 0) {
                    return mpg;   // if mpg is greater than or equal to 0, return mpg
                } else {
                    System.out.println("Please enter a non-negative value."); // otherwise prompt user to fix input
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid MPG.");
            }
        }
    }

    /**
     * Combines car information into a formatted string.
     *
     * @param model       The car's model.
     * @param releaseYear The car's release year.
     * @param trims       The car's trims.
     * @param carType     The car's type.
     * @param mpg         The car's MPG.
     * @return A string containing combined car information listed on separate lines.
     */
    public static String combine(String model, int releaseYear, ArrayList<String> trims, CarType carType, double mpg) {
        return "Model: " + model + "\n" +
                "Release Year: " + releaseYear + "\n" +
                "Trim(s): " + trims + "\n" +
                "Car Type: " + carType + "\n" +
                "MPG: " + mpg + "\n";
    }

    /**
     * Writes combined car information to a file called 'car.txt'.
     *
     * @param combinedInfo The combined car information.
     */
    public static void write(String combinedInfo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("car.txt"))) {
            writer.write(combinedInfo);
            System.out.println("Information written to car.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the contents of the 'car.txt' file.
     */
    public static void read() {
        Path filePath = Paths.get("car.txt");
        try {
            Files.lines(filePath).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    /**
     * This is the main method that collects the car information, combines it, writes it to a file, then  reads the file.
     *
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args) {
        String model = promptForModel();
        int releaseYear = promptForReleaseYear();
        ArrayList<String> trims = promptForTrims();
        CarType carType = promptForCarType();
        double mpg = promptForMPG();


        String combinedInfo = combine(model, releaseYear, trims, carType, mpg);
        write(combinedInfo);
        read();
    }
}
