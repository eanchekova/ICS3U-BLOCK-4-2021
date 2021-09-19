package week2;

public class StringExample {
    public static void main (String [] args) {
        String s1 = "Max"; //String literal
        String s2 = "Fred"; //String literal
        String s3 = new String ("Max"); //String object
        String s4 = new String ("Kyle"); //String object
        String s5 = new String ("Max"); //String object

        System.out.println(s1.length()); // length returns the number of characters in the String

        System.out.println(s1.equals(s5));
        System.out.println(s1.equals("max"));

        System.out.println("Brad".indexOf("ra"));
        System.out.println(s2.indexOf("Red"));

        String x = "ABCDEF";

        System.out.println(x.substring(2));
        System.out.println(x.substring(2, 4));
        System.out.println(x.substring(2, 3));
        System.out.println("Friday".substring(1, "Friday".length()));






    }
    
}
