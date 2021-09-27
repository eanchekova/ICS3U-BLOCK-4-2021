package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
        System.out.println(exampleFour(3, 23));
        System.out.println(exampleFive("relate"));
        System.out.println(exampleSix("Monkey", "nke"));
        System.out.println(exampleSeven("computer", "rose"));
        System.out.println(exampleEight(2.0, 4.0, 12.0, 22.0));
        System.out.println(exampleNine(6.5, 8.2));
        System.out.println(exampleTen("Blackboard"));
    }
    // (int)(Math.random() * numPossibilities) + lowest value

    public static void exampleOne() {
        int z = (int) (Math.random() * 100) + 1;
        System.out.println(z);

    }
    //Obtains and displays an integer between -50 and 50.

    public static void exampleTwo() {
        int y = (int) (Math.random() * 100) - 50;
        System.out.println(y);

    }
    //Simulate the roll of a die by obtaining and returning an integer from 1 to 6.

    public static void exampleThree() {
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println(dice);

    }
    //Create a function that accepts 2 ints (smaller and bigger)
    //and return a random integer between those two numbers inclusive.

    public static int exampleFour(int lowest, int highest) {
        int x = (int) (Math.random() * (highest - lowest + 1)) + lowest;
        return x;

    }
    //Create a function that accepts a String and returns a substring with the first "e" removed.

    public static String exampleFive(String str) {
        return str.substring(0, str.indexOf("e")) + str.substring(str.indexOf("e") + 1);

    }
    //Create a function that accepts a String and a substring and then
    //returns a String with the second string removed from the first String. 

    public static String exampleSix(String str, String substr) {
        return str.substring(0, str.indexOf(substr)) + str.substring(str.indexOf(substr) + substr.length());
        
    }
    //Create a function that accepts two Strings and returns the length 
    //of the two strings added together.

    public static int exampleSeven(String strOne, String strTwo) {
        return strOne.length() + strTwo.length();

    }
    //Create a function that takes 4 integers (x1,y1, x2,y2)
    //and obtains the slope of the line connecting those two points.

    public static double exampleEight(double x1, double x2, double y1, double y2) {
        return ((x1 - x2) / (y1 - y2));

    }
    //Create a function that can be used to calculate the volume of a cylinder. 
    //Radius and Height are the parameters for the function.

    public static double exampleNine(double r, double h) {
        return r * r * Math.PI * h;
    }
    //Create a function that removes a random characters from a String and returns the new string.

    public static String exampleTen(String str) {
        int randomChar = (int) (Math.random() * str.length()) + 1;
        return str.substring(0, randomChar) + str.substring(randomChar + 1);
    }
}