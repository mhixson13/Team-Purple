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
//import java.postgresql-42.3.3;

// class Student {
//     public int studentID;
//     public String Period;

//     public Student(int stuID, String Class) {
//         this.studentID = stuID;
//         this.Period = Class;
//     }
// }
// class Teacher {
//     public int teacherID;
// }
// class Question {
//     public int QuestionID;
//     public String TheQuestion;
//     public String QuestionType;

//     public Question(int QuestionID, String TheQuestion, String QuestionType) {
//         this.QuestionID = QuestionID;
//         this.TheQuestion = TheQuestion;
//         this.QuestionType = QuestionType;
//     }

//     public int getQuestionID() {
//         return this.QuestionID;
//     }
//     public String getTheQuestion() {
//         return this.TheQuestion;
//     }
//     public String getQuestionType() {
//         return this.QuestionType;
//     }
// }
// class User {
//     public String firstName;
//     public String lastName;
//     public int ID;

//     public Question[] question = new Question[100];

//     public User(String firstName, String lastName, int ID) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.ID = ID;
//     }

//     // public String getQuestion(int n) {
//     //     return this.question[n].TheQuestion;
//     // }
//     public void addRandomQs(int n) {
//         String[] array = {"T/F","MC","LK4","SA"};
//         int m = 0;
//         for(int i = 0; i < n; i++)
//         {
//             if(m == 4) 
//                 m = 0;
//             this.question[i] = new Question(i,"Question? " + i,array[m++]);
//         }
//     }

//     public String getFirstName() {
//         return this.firstName;
//     }
//     public void setFirstName(String firstName) {
//         this.firstName = firstName;
//     }
//     public String getLastName() {
//         return this.lastName;
//     }
//     public void setLastName(String lastName) {
//         this.lastName = lastName;
//     }
    
// }

// ---------------------------------

public class evaluation {

    public static String csv_file = "ex.csv";

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Connection c = null;
        String username = "";

        //String csv = "\copy teams(evalid, teamid, student) from 'evaluation-project/src/resources/teams.csv' delimiter ',' csv header;";
        //System.out.println(csv);

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
            

        // System.out.println("evalid\tclassid");

        // while(rs.next()) {
        //     System.out.print(rs.getInt(1));
        //     System.out.print("\t");
        //     System.out.print(rs.getInt(2));
        //     System.out.println("\t\t");
        // }

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

// -----------------------------
