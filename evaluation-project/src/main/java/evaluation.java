/* 
    Team Purple
    Julio Lopez, Marlon Miller, Miranda Hixson
    Peer Evaluation Project
    2/24/22
    CS 375

    javac evaluation.java
    java evaluation
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.IOException;
import java.util.*;
//import com.opencsv.*;
import java.io.*;

class User {
    public String firstName;
    public String lastName;
    public int ID;

    public User(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }
}
class Student {
    public int studentID;
    public String Period;

    public Student(int stuID, String Class) {
        this.studentID = stuID;
        this.Period = Class;
    }
}

public class evaluation {

    public static String csv_file = "ex.csv";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nWelcome to your Peer Evaluation Terminal Interface!");
        System.out.println("Created by Team-Purple\n");

        System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
        System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
        System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");

        System.out.println("The contents of the csv file are listed below.\n");
        parseCSV();

        // System.out.print("ID: ");
        // String ID = sc.nextLine();
        // System.out.print("Email: ");
        // String email = sc.nextLine();
        // System.out.print("Password: ");
        // String password = sc.nextLine();

        options();

        //User user1 = new User("Marlon","Miller",566449);
    }

    public static void options() {
        System.out.println("\nOptions:");
        System.out.println("   --Peer_Evaluations");
        System.out.println("   --Missing");
        System.out.println("   --Completed");
    }

    public static void parseCSV() {
        try {
            Scanner csvReader = new Scanner(new File(csv_file));

            // Parsing CSV into Scanner class
            csvReader.useDelimiter(",");

            while (csvReader.hasNext()) {
                System.out.print(csvReader.next());
            }

            csvReader.close();
            
        } catch (Exception e) {
            System.out.println("An error occured.\n");
            e.printStackTrace();
        }
    }

    // Parse CSV with OpenCSV Library
    // public static void parseCSV() {
    //     try {
    //         // Reads file
    //         FileReader fileReader = new FileReader(csv_file);

    //         // Creating CSV parser
    //         CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();

    //         // Reads CSV file into list
    //         List<String[]> csvData = csvReader.readAll();

    //         // Print Contents
    //         for(String[] row : csvData) {
    //             for(String cell : row) {
    //                 System.out.print(cell + "\t");
    //             }
    //             System.out.println();
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();        }
    // }
    
}
