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

import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.BufferedReader;

public class evaluation {

    public static String csv_file = "ex.csv";

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Connection c = null;
        String username = "";

        File responseCSV = new File("..\\..\\resources\\response.csv");
        File teamsCSV = new File("..\\..\\resources\\teams.csv"); 

        //String csv = "\\copy response(evalid, student1, student2, category, value) from '../../resources/response.csv' delimiter ',' csv header;";
        //System.out.println(csv);

        
        System.out.println("\nWelcome to your Peer Evaluation Terminal Interface!");
        System.out.println("From: Created by Team-Purple\n");

        System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
        System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
        System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");

        String results = parseCSV(responseCSV, "response");
        String teams = parseCSV(teamsCSV, "teams");

        while(true) {
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
                username, password);
                //System.out.println("Success Message: " + c);
                break;
            } catch (Exception e) {
                System.out.println("\nYour account or password is incorrect.\n");
                //System.out.println("C: "+ c);
                continue;
            }
        }

        System.out.println("\nWelcome " + username + "!");
        File allFiles = new File("..\\..\\resources");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".csv");
            }
        };
        String[] pathnames = allFiles.list(filter);

        String answer = "";
        while(true) {
            System.out.print("Do you wish to insert .csv files? (Y/N) ");
            answer = sc.nextLine();
            if(answer.equals("Y") || answer.equals("N"))
                break;
            System.out.println("Wrong input. Try again.");
            answer = sc.nextLine();
        }
        

        System.out.println("\nFiles:");
        for(String pathname : pathnames)
            System.out.println("*" + pathname);

        System.out.print("\n");
        while(true) {
            System.out.print("Choose your file: ");
            String choice = sc.nextLine();
            break;
        }

        
        insertCSV(c,teams);
    }

    public static void printEval(Connection c, String username) {
        String query = "select * from student;";
        ResultSet rs = null;
        try {

        PreparedStatement pstmt = c.prepareStatement(query);
        System.out.println("PSTMT: " + pstmt);
        rs = pstmt.executeQuery();
        System.out.println("Rs: " + rs);
        System.out.println("You are in the following team(s): ");
        String output = "";

        while(rs.next()) {
            // System.out.print("-- ");
            System.out.println(rs.getString(1));
            output += rs.getString(1) + "\n";
        }

        System.out.println("Output: \n" + output);
            
        } catch(Exception exec) {
            exec.printStackTrace();
        }
    }
    public static void insertCSV(Connection c, String query) {
        try {
            //System.out.println(query);
            Statement statement = c.createStatement();
            int rows = statement.executeUpdate(query);
            System.out.println("Statement was inserted");
            
            if(rows > 0) {
                System.out.println("Statement inserted.\n");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Your CSV file contains information already in our database.");
            System.out.println("Please check your file data.");
            //System.out.println("Error inside insertion");
        }
    }

    // -------------------------------------
    public static String parseCSV(File file, String tableName) {
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String query = "insert into " + tableName + "(" + line + ") values ";

            while(scanner.hasNextLine()) {
                query += "(" + scanner.nextLine() + "),";
            }

            query = query.substring(0,query.length()-1);
            query += ";";
            //System.out.println(query);

            scanner.close();
            return query;
            
        } catch (Exception e) {
            System.out.println("An error occured.\n");
            System.out.println("Statement didn't insert");
            e.printStackTrace();
        }
        return "";
    }
}
