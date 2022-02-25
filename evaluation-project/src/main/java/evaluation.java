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
import java.io.IOException;
import java.util.*;

import java.io.*;

class User {
    public String firstName;
    public String lastName;
    public int ID;

    public User(String fN, String lN, int id) {
        firstName = fN;
        lN = lastName;
        id = ID;
    }
}
class Student {
    public int studentID;
    public String Period;

    public void someMethod() {
        System.out.println("It works rn!");
    }

    public Student(int stuID, String Class) {
        this.studentID = stuID;
        this.Period = Class;
    }
}

public class evaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String FirstName, LastName, ID;
        String typePerson;

        System.out.println("\nEvaluation Project by Team Purple\n");

        System.out.print("Teacher or Student? ");
        typePerson = sc.nextLine();

        System.out.print("First Name: " );
        FirstName = sc.nextLine();
        System.out.print("Last Name: ");
        LastName = sc.nextLine();
        System.out.print("ID: ");
        ID = sc.nextLine();

        System.out.println("Welcome to your Peer Evaluation " + FirstName + " " + LastName);

        User user1 = new User("Marlon","Miller",566449);
    }

    
    // Project Code Here
}
