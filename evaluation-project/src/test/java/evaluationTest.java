/* 
    Team Purple
    Julio Lopez, Marlon Miller, Miranda Hixson
    Peer Evaluation Project
    2/24/22
    CS 375

    mvn compile
    mvn clean
    mvn test
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.Math;
import org.junit.*;

public class evaluationTest {
    evaluation eval;

    @Before
    public void initialize() {
        eval = new evaluation();
    }

    @Test
    public void sampleTest() {
        try {
            int a = 1, b = 1, c = 2;
            assertEquals(c, a + b);
        } catch(Exception e) {
            System.out.println("\nTest Failed.\n");
        }
    }

    @Test
    public void test1() {
        try {
            User user1 = new User("Marlon","Miller",566449);
            assertEquals(user1.getLastName(),"Miller");
        } catch(Exception e) { 
            System.out.println("\nTest Failed");
        }
    }

    @Test
    public void test2() {
        try {
            User user1 = new User("Miranda","Hixson",123123);
            user1.addRandomQs(5);
            assertEquals(user1.question[0].getQuestionID(),0);
        } catch(Exception e) { 
            System.out.println(e);
        }
    }

    @Test
    public void test3() {
        try {
            User user1 = new User("Julio","Lopez",321321);
            user1.addRandomQs(5);
            assertEquals(user1.question[4].getQuestionType(),"T/F");
        } catch(Exception e) { 
            System.out.println("\nTest Failed");
        }
    }

    @Test
    public void test4() {
        try {
            User user1 = new User("Dr","Reeves",198231);
            user1.addRandomQs(5);
            assertEquals(user1.question[2].getTheQuestion(),"Question? 2");
        } catch(Exception e) { 
            System.out.println("\nTest Failed");
        }
    }

    @Test
    public void test5() {
        try {
            User user1 = new User("John","Homer",123321);
            user1.addRandomQs(10);
            assertEquals(user1.question[9].QuestionType,"MC");
        } catch(Exception e) { 
            System.out.println("\nTest Failed");
        }
    }
}