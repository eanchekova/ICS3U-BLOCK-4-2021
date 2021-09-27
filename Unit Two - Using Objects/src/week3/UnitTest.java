package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(threeCopies("Apple", 3));
        System.out.println(threeCopies("Computer", 2)); 
        System.out.println(removeChars("Computer Science", 3, 4));
        System.out.println(removeChars("Tired", 2, 3));
        System.out.prinnln(sqrtSum(9999));
    }
    /** 
     * write a function that accepts a String and an integer. return 3 copies 
     * of a substring of length 2 at the specified index. 
     */

     public static String threeCopies(String str, int index) {
         String s = str.substring(index, index + 2); 
         return s + s + s; 
     }

     public static String removeChars(String str, int index, int n) {
            String first = str.substring(0, index); 
            String last = str.substring(index + n);
            return first + last; 
     }

     public static double sqrtSum(int number) {
         int n1 = number / 1000; 
         int n2 = number / 100 % 10; 
         int n3 = number / 10 % 10; 
         int n4 = number % 10; 

         int sum = n1 + n2 + n3 + n4; 
         return Math.sqrt(sum); 
     }
}
