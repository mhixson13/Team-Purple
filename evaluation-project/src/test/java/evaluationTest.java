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
    
    @Test
    public void sql_1() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from student;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += rs.getString(1) + "\n";
            }

            assertEquals("id01\nid02\nid03\nid04\nid05\nid06\nid07\nid08\nid09\nid10\nid11\nid12\nid13\nid14\nid15\nid16\nid17\nid18\nid19\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_1 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_2() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from teams;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += Integer.toString(rs.getInt(1)) + " ";
                output += Integer.toString(rs.getInt(2)) + " ";
                output += Integer.toString(rs.getInt(3)) + "\n";
            }

            assertEquals("1 1 1\n1 1 2\n1 1 3\n1 2 4\n1 2 5\n1 2 6\n1 3 7\n1 3 8\n1 3 9\n2 1 2\n2 1 3\n2 1 4\n2 2 5\n2 2 6\n2 2 7\n2 3 8\n2 3 9\n2 3 10\n",output);
            //1 1 1\n1 1 2\n1 1 3\n1 2 4\n1 2 5\n1 2 6\n1 3 7\n1 3 8\n1 3 9\n1 4 10\n1 4 11\n1 4 12\n1 5 13\n1 5 14\n1 5 15\n1 6 16\n1 6 17\n1 7 18\n1 7 19\n
            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_2 Test has failed");
                e.printStackTrace();
            }
    }
    @Test
    public void sql_3() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select count(*) from response where student1 = 3";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += Integer.toString(rs.getInt(1)) + " ";
                // output += rs.getString(2) + " ";
                // output += rs.getString(3) + " ";
                // output += rs.getString(4) + "\n";
            }

            assertEquals("15 ",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }
    @Test
    public void sql_4() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select count(*) from response;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += Integer.toString(rs.getInt(1)) + " ";
                //output += Double.toString(rs.getDouble(2)) + "\n";
            }

            assertEquals("265 ",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_5() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select teamid, count(teamid) from teams group by teamid order by teamid;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += Integer.toString(rs.getInt(1)) + " ";
                output += Integer.toString(rs.getInt(2)) + "\n";
            }

            assertEquals("1 6\n2 6\n3 6\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_6() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select count(*) from teams;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                // System.out.print("-- ");
                // System.out.println(rs.getString(1));
                output += Integer.toString(rs.getInt(1)) + " ";
                // output += Integer.toString(rs.getInt(2)) + " ";
                // output += Integer.toString(rs.getInt(3)) + " ";
                // output += rs.getString(4) + " ";
                // output += Integer.toString(rs.getInt(5)) + "\n";
            }

            assertEquals("18 ",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_7() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select avg(value) from response;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                output += Double.toString(rs.getDouble(1)) + "\n";
            }

            assertEquals("3.9547169811320755\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }
    @Test
    public void sql_8() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from teams where student = 2;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                output += rs.getString(1) + " ";
                output += rs.getString(2) + "\n";
            }

            assertEquals("1 1\n2 1\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_9() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from teams where teamid = 2;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                output += Integer.toString(rs.getInt(1)) + " ";
                output += Integer.toString(rs.getInt(2)) + " ";
                output += Integer.toString(rs.getInt(3)) + "\n";
            }

            assertEquals("1 2 4\n1 2 5\n1 2 6\n2 2 5\n2 2 6\n2 2 7\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }

    @Test
    public void sql_10() {
        Connection c = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        String query = "select * from teams where teamid = 3;";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cs375v1",
            "mrblee", "purplewhite");
            
            PreparedStatement pstmt = c.prepareStatement(query);
            rs = pstmt.executeQuery();
            String output = "";

            while(rs.next()) {
                output += Integer.toString(rs.getInt(1)) + " ";
                output += Integer.toString(rs.getInt(2)) + " ";
                output += Integer.toString(rs.getInt(3)) + "\n";
            }

            assertEquals("1 3 7\n1 3 8\n1 3 9\n2 3 8\n2 3 9\n2 3 10\n",output);

            // assertNotNull(c);
            } catch (Exception e) {
                System.out.println("sql_3 Test has failed");
                e.printStackTrace();
            }
    }
}