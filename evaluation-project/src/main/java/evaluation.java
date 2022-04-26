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
                break;
            } catch (Exception e) {
                System.out.println("\nYour account or password is incorrect.\n");
                continue;
            }
        }

        System.out.println("\nWelcome " + username + "!");

        if(username.equals("mrblee")) 
            mainMenu(c);
        else 
            studentMenu(c,username);
    }

    public static void studentMenu(Connection c, String student) {
        String answer = "";
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n*-- Main Menu --*");
            System.out.println("1) Generate my Report");
            System.out.println("2) Quit");
            
            System.out.print("\nSelect a number option: ");
            answer = sc.nextLine();

            switch(answer) {
                case "1":
                case "1)":
                    createStudentHtml(c,student);
                    System.out.println("Report 'studentReport.html' has been created\n");
                    break;
                case "2":
                case "2)":
                case "Quit":
                    System.out.println("System being shut down.");
                    break;
                default:
                    System.out.println("Option not available.");
                    System.out.println("Try again.\n");
                    break;   
            }
            if(answer.equals("2") || answer.equals("2)") || answer.equals("Quit"))
                break;
        }
    }

    public static void createStudentHtml(Connection c, String Student) {
        String query = "select evalid, case when rator != '" + Student + 
        "' then 'ANON' else '" + Student + "' end as rator, case when ratee != '" + 
        Student + "' then 'ANON' else '" + Student + "' end as ratee, category, value " + 
        "from v_table_names where rator = '" + Student + "' or ratee = '" + Student + "';";
        System.out.println(query);
    }

    public static void mainMenu(Connection c) {
        String answer = "";
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n*-- Main Menu --*");
            System.out.println("1) Generate Report");
            System.out.println("2) Insert CSV");
            System.out.println("3) Quit");

            System.out.print("\nSelect a number option: ");
            answer = sc.nextLine();

            switch(answer) {
                case "1":
                case "1)":
                    createHtml(c);
                    System.out.println("Report 'MainReport.html' has been created\n");
                    break;
                case "2":
                case "2)":
                    arrangeCSV(c);
                    break;
                case "3":
                case "3)":
                case "Quit":
                    System.out.println("System being shut down.");
                    break;
                default:
                    System.out.println("Option not available.");
                    System.out.println("Try again.\n");
                    //mainMenu(c);
                    break;
            }

            if(answer.equals("3") || answer.equals("3)") || answer.equals("Quit"))
                break;
        }
    }

    public static void arrangeCSV(Connection c) {

        String answer = "";
        Scanner sc = new Scanner(System.in);

        File responseCSV = new File("..\\..\\resources\\response.csv");
        File teamsCSV = new File("..\\..\\resources\\teams.csv");
        String results = parseCSV(responseCSV, "response");
        String teams = parseCSV(teamsCSV, "teams");

        File f = new File("..\\..\\resources");
        
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".csv");
            }
        };    

        String[] pathnames = f.list(filter);

        while(true) {
            System.out.println("\n.csv files:");
            int n = 1;
            for(String pathname : pathnames) {
                System.out.println(n++ + ") " + pathname);
            }

            System.out.println(n + ") Return");
            System.out.print("\nChoose any .csv file you want to insert: ");
            answer = sc.nextLine();
            switch(answer) {
                case "response":
                case "response.csv":
                case "1":
                case "1)":
                    insertCSV(c,results);
                    break;
                case "teams":
                case "teams.csv":
                case "2":
                case "2)":
                    insertCSV(c,teams);
                    break;
                case "Return":
                case "return":
                case "3":
                case "3)":
                    break;
                default:
                    System.out.println("Option not available.");
                    System.out.println("Try again.");
                    break;
            }
            if(answer.equals("return") || answer.equals("Return") || answer.equals("3") || answer.equals("3)"))
                break;
        } 
    }

    public static void createHtml(Connection c) {
        String extreme_query = "select * from v_official_extreme;", general_query = "select * from v_Official_general_avg;", sd_query = "select * from v_official_std_cat;";
        String html_doctype = "<!DOCTYPE html>", html_1 = "<html>", html_2 = "</html>", head_1 = "<head>", head_2 = "</head>", body_1 = "<body>", body_2 = "</html>";
        String table_header = "<table border=\"1\" align=center>", table_close = "</table>", table_caption_1 = "<caption>", table_caption_2 = "</caption>";
        String th_1 = "<th align=\"center\">", th_2 = "</th>";
        String tr_1 = "<tr valign=\"top\">", tr_2 = "</tr>", td_1right = "<td align=\"right\">", td_1left = "<td align=\"left\">", td_2 = "</td>";
        String mainHTML = "";
        //System.out.println("query: "+ extreme_query);
        ResultSet rs = null;

        try {
            // Create and write HTML file
            File html_file = new File("..\\..\\resources\\main-report.html");
            FileWriter writeFile = new FileWriter("..\\..\\resources/main-report.html");

            // General Table
            PreparedStatement pstmt = c.prepareStatement(general_query); 
            rs = pstmt.executeQuery();

            mainHTML += html_doctype + html_1 + head_1 + head_2 + body_1;

            mainHTML += table_header + table_caption_1 + "General Table" + table_caption_2 + "<tr>";
            mainHTML += th_1 + "evalid" + th_2 + th_1 + "rator" + th_2 +   th_1 + "ratorno" + th_2 + th_1 + "r1c" + th_2 + th_1 + "r1h" + th_2 + th_1 + "r1i" + th_2 + th_1 + "r1e" + th_2 + th_1 + "r1k" + th_2 + th_1 + "r2c" + th_2 + th_1 + "r2h" + th_2 + th_1 + "r2i" + th_2;
            mainHTML += th_1 + "r2e" + th_2 + th_1 + "r2k" + th_2 +   th_1 + "r3c" + th_2 + th_1 + "r3h" + th_2 + th_1 + "r3i" + th_2 + th_1 + "r3e" + th_2 + th_1 + "r3k" + th_2 + th_1 + "avg_w_self" + th_2 + th_1 + "avg_no_self" + th_2 + th_1 + "sd_w_self" + th_2 + th_1 + "sd_wihtout_self" + th_2 + "</tr>";
            
            while(rs.next()) {
                mainHTML += tr_1;
                for(int i = 1; i <= 22; i++) {
                    mainHTML += td_1right + rs.getString(i) + td_2;
                }
                mainHTML += tr_2;
            }
            mainHTML += table_close;
            mainHTML += "<br></br>";

            // Extreme Table
            pstmt = c.prepareStatement(extreme_query); 
            rs = pstmt.executeQuery();

            mainHTML += table_header + table_caption_1 + "Extreme Level" + table_caption_2 + "<tr>";
            mainHTML += th_1 + "evalid" + th_2 + th_1 + "student" + th_2 + th_1 + "C" + th_2 + th_1 + "H" + th_2 + th_1 + "E" + th_2 + th_1 + "I" + th_2 + th_1 + "K" + th_2 + "</tr>"; // Table Column Names

            while(rs.next()) {

                mainHTML += tr_1;
                mainHTML += td_1right + rs.getString(1) + td_2 + td_1right + rs.getString(2) + td_2;

                for(int i = 3; i <= 7; i++) {
                    mainHTML += td_1left + rs.getString(i) + td_2;
                }

                mainHTML += tr_2;

                // System.out.print(rs.getString(1) + "\t");
                // System.out.print(rs.getString(2) + "\t");
                // System.out.print(rs.getString(3) + "\t");
                // System.out.print(rs.getString(4) + "\t");
                // System.out.print(rs.getString(5) + "\t");
                // System.out.print(rs.getString(6) + "\t");
                // System.out.println(rs.getString(7));
            }
            mainHTML += table_close;

            mainHTML += "<br></br>";

            // STD Table
            pstmt = c.prepareStatement(sd_query); 
            rs = pstmt.executeQuery();

            mainHTML += table_header + table_caption_1 + "Standard Deviation p/Student/Category" + table_caption_2 + "<tr>";
            mainHTML += th_1 + "evalid" + th_2 + th_1 + "student" + th_2 + th_1 + "C" + th_2 + th_1 + "H" + th_2 + th_1 + "E" + th_2 + th_1 + "I" + th_2 + th_1 + "K" + th_2 + "</tr>";
            
            while(rs.next()) {
                mainHTML += tr_1;
                for(int i = 1; i <= 7; i++) {
                    mainHTML += td_1right + rs.getString(i) + td_2;
                }
                mainHTML += tr_2;
            }
            mainHTML += table_close;

            mainHTML += body_2 + html_2;
            writeFile.write(mainHTML); // Writes the whole string into the HTML
            writeFile.close();
            System.out.println("Successfully created HTML file.");
        } 
        catch(Exception exec) {
            System.out.println("Error in creating HTML.");
            exec.printStackTrace();
        }
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
