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

    public User(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
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

        System.out.println("\n\nWelcome to your Peer Evaluation Terminal Interface!");
        System.out.println("Created by Team-Purple\n");

        System.out.println(" *Documentation:                   https://github.com/mhixson13/Team-Purple/tree/main/Documentation");
        System.out.println(" *UML Diagrams:                    https://github.com/mhixson13/Team-Purple/tree/main/uml");
        System.out.println(" *More:                            https://github.com/mhixson13/Team-Purple\n");


        System.out.print("ID: ");
        String ID = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        options();

        User user1 = new User("Marlon","Miller",566449);
    }

    public static void options() {
        System.out.println("\nOptions:");
        System.out.println("   --Peer_Evaluations");
        System.out.println("   --Missing");
        System.out.println("   --Completed");
    }

}
