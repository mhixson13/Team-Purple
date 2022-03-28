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

        while(true) {
            System.out.print("\nUsername: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            username, password);
            break;
            } catch (Exception e) {
                System.out.println("\nYour account or password is incorrect.");
                // e.printStackTrace();
                // System.err.println(e.getClass().getName()+": "+e.getMessage());
                // System.exit(0);
                continue;
            }
        }
        
        System.out.println("\nWelcome back " + username + "!\n");
        System.out.println("Here are your active evaluations:");

        String query = "select * from evaluation order by evalid";
        ResultSet rs = null;

        try {

        PreparedStatement pstmt = c.prepareStatement(query);
        rs = pstmt.executeQuery();

        System.out.println("evalid\tclassid");

        while(rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print("\t");
            System.out.print(rs.getInt(2));
            System.out.println("\t\t");
        }

        } catch(Exception exec) {
            exec.printStackTrace();
        }

        

//         String jdbcURL = "jdbc:postgresql://localhost:5432/cs375v1";
// //        String username = "mrblee";
// //        String password = "purplewhite";
        
//         System.out.println("\n\nWelcome to your Peer Evaluation Terminal Interface!");
//         System.out.println("Created by Team-Purple\n");

//         System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
//         System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
//         System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");
        
//         System.out.print("Username: ");
//         String username = sc.nextLine();
//         System.out.print("Password: ");
//         String password = sc.nextLine();
        
//         try {
//             Connection connection = DriverManager.getConnection(jdbcURL,username,password);
//             System.out.println("Connected to PostgreSQL server");
            
//             String sql = "insert into class (class_id, class_name) values "
//             		+ "(5005,'SE1');";
            
//             Statement statement = connection.createStatement();
//             int rows = statement.executeUpdate(sql);
//             if(rows > 0) {
//             	System.out.println("A new statement has been inserted");
//             }
            	
//             connection.close();
//         } catch (SQLException e) {
//             System.out.println("Error in connecting to PostgreSQL server");
//             e.printStackTrace();
//         }


        // System.out.println("\n\nWelcome to your Peer Evaluation Terminal Interface!");
        // System.out.println("Created by Team-Purple\n");

        // System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
        // System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
        // System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");

        // System.out.println("The contents of the csv file are listed below.\n");
        // parseCSV();

        
//         System.out.print("ID: ");
//         String ID = sc.nextLine();
//         System.out.print("Email: ");
//         String email = sc.nextLine();
//         System.out.print("Password: ");
//         // String password = sc.nextLine();
//         System.out.println();

        // User user1 = new User("Marlon","Miller",566449);
        //options();

        //User user1 = new User("Marlon","Miller",566449);
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

//            System.out.println("\nThis are the following Evaluations");
//            sql = "select class_name from class;";
//            
//            ResultSet result = statement.executeQuery(sql);
//            System.out.print(result);
//            
//            while(result.next()) {
//            	String classes = result.getString("class_name");
////            	String evalid = result.getString("evalid");
////            	String questionid = result.getString("question_id");
////            	String text = result.getString("text");
//            	
//            	System.out.printf("%d - %s - %s - %s\n", classes);
//            }
