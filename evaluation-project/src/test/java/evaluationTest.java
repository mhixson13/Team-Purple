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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.lang.Math;
import org.junit.*;

public class evaluationTest {
    evaluation eval;

    int testCount = 0;

    @Before
    public void initialize() {
        eval = new evaluation();
    }

    @Test
    public void test1() {
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
    public void test2() {
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
    public void test3() {
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
    public void test4() {
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
    public void test5() {
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
    public void test6() {
        String username = "jjl18b", password = "jjl18b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }
    }

    @Test
    public void test7() {
        String username = "mbh18b", password = "mbh18b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void test8() {
        String username = "mem19b", password = "mem19b";
        try {
            assertEquals(username, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        } 
    }

    @Test
    public void test9() {
        String username = "mrblee", password = "purplewhite", verifiedPassword = "purplewhite";
        try {
            assertEquals(verifiedPassword, password);
        } catch (Exception e) {
            System.out.print("\nTest " + (++testCount) + "Failed.");
        }  
    }

    @Test
    public void test10() {
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
    public void test11() {
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
    public void test12() {
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
    public void test13() {
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
    public void test14() {
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
    public void test15() {
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
    public void test16() {
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
    public void test17() {
        String username = "jjl18b", password = "jjl18d";

        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void test18() {
        String username = "mbh18b", password = "mbh18d";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void test19() {
        String username = "mem19b", password = "mem19d";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void test20() {
        String username = "mrblee", password = "purplewhite";
        try {
            assertNotEquals(username, password);
        } catch (Exception e) {
             System.out.print("\nTest " + (++testCount) + "Failed.");
         } 
    }

    @Test
    public void test21() {
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
    public void test22() {
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
    public void test23() {
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
    public void test24() {
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
    public void test25() {
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
    public void test26() {
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
    public void test27() {
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
    public void test28() {
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
    public void test29() {
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
    public void test30() {
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
}