package week2;

/**
 * Write a program that takes a decimal number then displays the number and the
 * square to the console in a presentable way.
 */

public class HW1 {

    public static void main (String [] args) {
        double num = 7.2;
        double numSqrd = num * num; 

        System.out.println(num + " x " + num + " = " + numSqrd);

/**
 * Create a program that obtains two integers, one for the amount a test is out 
 * of and another indicating what a student received. Display what percentage the 
 * student received on the test.
 */

 int numOutof = 40; 
 int numScore = 35; 

 double numAverage = ((double) numScore / numOutof) * 100;

 System.out.println(numAverage + "%");

 /**
  * Write a program that uses a five digit number and calculates
  *  the product of the 2nd and 4th digit. Use the modulus and and 
  * division operators.
  */

  int numBig = 76432;

  int numTwo = numBig % 10000 / 1000;
  int numFour = (numBig / 10) % 10;

  int numAnswer = numTwo * numFour;

  /**
   * Create a program that can be used to calculate the final velocity 
   * of a car given the initial velocity, the acceleration of the car and 
   * the time that has elapsed using the following equation:
   */

   double vi = 18.3;
   double ac = 7.4;
   double t = 4.2;

   double vFinal = vi + (ac * t);

   /**
    * Write program that can calculate the area of circle. You will 
    * need to create variables for the radius and the area.
    */

   final double pi = 3.14159;
   double d = 3.3;
   double circ;

   circ = pi * d; 

   /**
    * Write a program that can calculate the volume of a sphere.
    */

    final double piSix = 3.14159; 
    double r = 1.2; 
    
    double v = (double) 4/3* (double) piSix * (double) r * (double) r * (double) r;



   /**
    * Create a program that can solve the equation 
    * y = ax2+bx+c given a, b, c and x. 
    */ 

    int a = 1; 
    int b = 3;
    int c = 4;
    int x = 2; 
    int xSquare = (int) Math.pow(x , 2);
    
    int y = (a * xSquare) + (b * x) + c; 

    /**
     * Write a program to calculate the slope of a line
     *  give (x1, y1) and (x2,y2).
     */

     int xOne = 3;
     int xTwo = 4;
     int yOne = 2;
     int yTwo = 5;

     double s = (yTwo - yOne)/(xTwo - xOne);

     /**
      * 9.	Write a program that given the number of pennies, nickles, dimes, 
      * quarters, loonies and toonies calculates how much money the user has.
      */

      int numberP = 5;
      int numberN = 4;
      int numberD = 2; 
      int numberQ = 4; 
      int numberL = 1; 
      int numberT = 3; 
      
      double p = 0.01; 
      double n = 0.05; 
      double di = 0.1; 
      double q = 0.25; 
      double l = 1.0; 
      double to = 2.0; 

      double totalMoney = (numberP * p) + (numberN * n) + (numberD * di) + (numberQ * q) + (numberL * l) + (numberT * to);

       /**
        * 10.	Math.sqrt(x), where x is a value can be used to calculate the square root.
        *  Given an equation in the format from question 7.  Obtain the two roots. 
        * Given a, b, and c. 
        */

        int aa = 2; 
        int bb = 4; 
        int cc = 6; 
        int discrim = (bb * bb) - 4 *aa * cc; 
        double rootOne = (-bb + Math.sqrt(discrim)) / 2 * aa;
        double rootTwo = (-bb - Math.sqrt(discrim)) / 2 * aa; 
        
        System.out.println("The two roots are" + rootOne + "and" + rootTwo);




    }
    
}
