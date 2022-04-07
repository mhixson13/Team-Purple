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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.lang.Math;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner; 

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.BufferedReader;

public class evaluationTest {
    evaluation eval;

    int testCount = 0;

    @Before
    public void initialize() {
        eval = new evaluation();
    }

    @Test
    public void java_1() {
        String s = "1, 000561003, 000123456, 8, 4";
	    char actual = '4';
        try {
            char c = s.charAt(s.length()-1);
            assertEquals(actual, c);
        } catch (Exception e) {
            System.out.println("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test 
    public void java_2() {
        String s = "1, 000561003, 000123456, 8, 5";
	    char actual = '5'; 
        try {
            char c = s.charAt(s.length()-1);
            assertEquals(actual, c);
        } catch (Exception e) {
            System.out.println("\nTest " + (++testCount) + "Failed."); 
        }
    }

    @Test
    public void java_3() {
        String s = "1, 000561003, 000123456, 8, 5";
        int actual = 4, count = 0, i = 0;

        try {
            for(char c: s.toCharArray()) {
                if(s.charAt(i) == ',') {
                    count++;
                }
                i++;
            }
            assertEquals(actual, count);
       } catch (Exception e) {
            System.out.println("\nTest " + (++testCount) + "Failed.");
       }
    }

    @Test
    public void java_4() {
        String s = "1, 000561003, 000123456, 8, 5";
        int actual = 29, count = 0;

        try {
            for(char c: s.toCharArray()) {
                count++;
            }
            assertEquals(actual, count);
        } catch (Exception e) {
            System.out.println("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test
    public void java_5() {
        String s = "1, 000561003, 000123456, 8, 5"; 
        int count = 0, i = 0, actual = 9;
        try {
            for(char c: s.toCharArray()) {
                if(i >=3 && i <= 11) {
                    count++;
                }
                i++;
            }
            assertEquals(actual, count);
        } catch (Exception e) {
            System.out.println("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test
    public void java_6() {
        String username = "jjl18b", password = "jjl18b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test
    public void java_7() {
        String username = "mbh18b", password = "mbh18b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void java_8() {
        String username = "mem19b", password = "mem19b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void java_9() {
        String username = "mrblee", password = "purplewhite", verifiedPassword = "purplewhite";
        try {
            assertEquals(verifiedPassword, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }  
    }

    @Test
    public void java_10() {
        String username = "jjl18b", password = "jjl18b", verifiedPassword = "jjl18b";
        int count = 0, actual = 6;
        try {
            for(int i = 0; i < username.length(); i++) {
                if(password.toCharArray()[i] == verifiedPassword.toCharArray()[i]) {
                    count++;
                }
            }
            assertEquals(count, actual);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void java_11() {
        String username = "mbh18b", password = "mbh18b", verifiedPassword = "mbh18b";
        int count = 0, actual = 6;
        try {
            for(int i = 0; i < username.length(); i++) {
                if(password.toCharArray()[i] == verifiedPassword.toCharArray()[i]) {
                    count++;
                }
            }
            assertEquals(count, actual);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }  
    }

    @Test
    public void java_12() {
        String username = "mrblee", password = "purplewhite", verifiedPassword = "purplewhite";
        int count = 0, actual = 6;
        try {
            for(int i = 0; i < username.length(); i++) {
                if(password.toCharArray()[i] == verifiedPassword.toCharArray()[i]) {
                    count++;
                }
            }
            assertEquals(count, actual);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }  
    }

    @Test
    public void java_13() {
        String username = "mem19b", password = "mem19b", verifiedPassword = "mem19b";
        int count = 0, actual = 6;
        try {
            for(int i = 0; i < username.length(); i++) {
                if(password.toCharArray()[i] == verifiedPassword.toCharArray()[i]) {
                    count++;
                }
            }
            assertEquals(count, actual);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void java_14() {
       String username = "jjl18b";
       char actual = 'b';

       try {
            char c = username.charAt(username.length()-1);
            assertEquals(actual, c);
       } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
       
    }

    @Test
    public void java_15() {
        String username = "mbh18b";
        char actual = 'b';

        try {
            char c = username.charAt(username.length()-1);
            assertEquals(actual, c);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_16() {
        String username = "mem19b";
        char actual = 'b';

        try {
            char c = username.charAt(username.length()-1);
            assertEquals(actual, c);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_17() {
        String username = "jjl18b", password = "jjl18d";

        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_18() {
        String username = "mbh18b", password = "mbh18d";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_19() {
        String username = "mem19b", password = "mem19d";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_20() {
        String username = "mrblee", password = "purplewhite";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_21() {
        String username = "jjl18b";
        int count = 0, actual = 2, i = 0;

        try {
            for(char c: username.toCharArray()) {
                if(username.charAt(i) == '1' || username.charAt(i) == '8') {
                    count++;
                }
                i++; 
            }
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         }
    }

    @Test
    public void java_22() {
        String username = "mbh18b";
        int count = 0, actual = 2, i = 0;

        try {
            for(char c: username.toCharArray()) {
                if(username.charAt(i) == '1' || username.charAt(i) == '8') {
                    count++;
                }
                i++; 
            }
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_23() {
        String username = "mem19b";
        int count = 0, actual = 2, i = 0;

        try {
            for(char c: username.toCharArray()) {
                if(username.charAt(i) == '1' || username.charAt(i) == '9') {
                    count++;
                }
                i++; 
            }
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_24() {
        String username = "mrblee";
        int count = 0, actual = 2, i = 0;

        try {
            for(char c: username.toCharArray()) {
                if(username.charAt(i) == 'e') {
                    count++;
                }
                i++; 
            }
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_25() {
        String username = "jjl18b", password = "jjl18b";
        int count = 0, actual = 6, i = 0;

        try {
            for(char c: username.toCharArray()) {
                if(username.charAt(i) == password.charAt(i)) {
                    count++;
                }
                i++; 
            }
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_26() {
        String username = "mrblee", password = "purplewhite";

        try {
            if(username == password) {
                assertEquals(username, password);
            }
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_27() {
        String username = "jjl18b", password = "jjl18b", verifiedPassword = "jjl18b";
        int count = 0, i = 0, actual = 2;

        try {
            for(char c: username.toCharArray()) {
                if(i >= 3 && i < 5) {
                    count++;
                }
                i++;
            } 
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_28() {
        String username = "mbh18b", password = "mbh18b", verifiedPassword = "mbh18b";
        int count = 0, i = 0, actual = 2;

        try {
            for(char c: username.toCharArray()) {
                if(i >= 3 && i < 5) {
                    count++;
                }
                i++;
            } 
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_29() {
        String username = "mem19b", password = "mem19b", verifiedPassword = "mem19b";
        int count = 0, i = 0, actual = 2;
        
        try {
            for(char c: username.toCharArray()) {
                if(i >= 3 && i < 5) {
                    count++;
                }
                i++;
            } 
            assertEquals(actual, count);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void java_30() {
        String username = "jjl18b", password = "jjl18b", verifiedPassword = "jjl18b";
        int count = 0, actual = 6;
        try {
            for(int i = 0; i < username.length(); i++) {
                if(password.toCharArray()[i] == verifiedPassword.toCharArray()[i]) {
                    count++;
                }
            }
            assertEquals(count, verifiedPassword.length());
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test
    public void java_31() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_31 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_32() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhITE");
            System.out.println("Java_32 Test has failed");
            //assertNull(c);
            } catch (Exception e) {
                assertNull(c);
                // System.out.println("Java_32 Test has failed");
                // System.out.println("C Message: " + c);
                // e.printStackTrace();
            }
    }

    @Test
    public void java_33() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "asj18a", "asj18a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_33 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_34() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "bah20a", "bah20a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_34 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_35() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "cgg20a", "cgg20a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_35 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_36() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "fwc17a", "fwc17a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_36 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_37() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "gbp18a", "gbp18a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_37 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_38() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "jjl18b", "jjl18b");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_38 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_39() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "jmr18c", "jmr18c");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_39 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void java_40() {
        Connection c = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "lai19a", "lai19a");
            assertNotNull(c);
            } catch (Exception e) {
                System.out.println("Java_40 Test has failed");
                e.printStackTrace();
            }
    }
}