/* 
    Team Purple
    Julio Lopez, Marlon Miller, Miranda Hixson
    Peer Evaluation Project
    2/24/22
    CS 375

    Instructions:
    javac -cp ".:postgresql-42.3.3.jar"  evaluation.java
    java -cp postgresql-42.3.3.jar evaluation.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.IOException;
import java.util.*;
//import com.opencsv.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class evaluation {

    public static String csv_file = "ex.csv";

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Connection c = null;
        String username = "";

        File responseCSV = new File("..\\..\\resources\\response.csv");
        File teamsCSV = new File("..\\..\\resources\\teams.csv"); 

        parseCSV(responseCSV);
        parseCSV(teamsCSV);

        String csv = "\\copy teams(evalid, teamid, student) from 'evaluation-project/src/resources/teams.csv' delimiter ',' csv header;";

        
        System.out.println("\nWelcome to your Peer Evaluation Terminal Interface!");
        System.out.println("From: Created by Team-Purple\n");

        System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
        System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
        System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");

        while(true) {
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            username, password);
            break;
            } catch (Exception e) {
                System.out.println("\nYour account or password is incorrect.\n");
                // e.printStackTrace();
                // System.err.println(e.getClass().getName()+": "+e.getMessage());
                // System.exit(0);
                continue;
            }
        }
        
        System.out.println("\nWelcome " + username + "!\n");
       // printEval(c,username);
    }

    public static void printEval(Connection c, String username) {
        String query = "select a.teamname from teams a inner join users b on a.bannerid = b.bannerid where b.username = '" + username  + "';";
        ResultSet rs = null;
        try {

        PreparedStatement pstmt = c.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("You are in the following team(s): ");

        while(rs.next()) {
            System.out.print("-- ");
            System.out.println(rs.getString(1));
        }
            
        } catch(Exception exec) {
            exec.printStackTrace();
        }
    }

    // -------------------------------------

    public static void options() {
        System.out.println("\nOptions:");
        System.out.println("   --Peer_Evaluations");
        System.out.println("   --Missing");
        System.out.println("   --Completed");
    }

    public static void parseCSV(File file) {
        try {
            Scanner csvReader = new Scanner(file);

            // Parsing CSV into Scanner class
            csvReader.useDelimiter(", ");

            while (csvReader.hasNext()) {
                System.out.print(csvReader.next());
            }

            csvReader.close();
            System.out.println("\n");

            // System.out.println("\n");

            // csvReader = new Scanner(teamsCSV);
            // csvReader.useDelimiter(",");
            // while (csvReader.hasNext()) {
            //     System.out.print(csvReader.next());
            // }

            // csvReader.close();
            
        } catch (Exception e) {
            System.out.println("An error occured.\n");
            e.printStackTrace();
        }
    }
}
