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
}