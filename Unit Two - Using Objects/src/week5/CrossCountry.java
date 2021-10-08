package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();

    }

/**
 * @param in
 */
    
    private static void processRunner(Scanner in) {
        String firstName, lastName; 
        String mileOne, mileTwo, finish; 
        String splitTwo, splitThree; 

/**
 * get the first and last name of the runner 
 * get the mileOne, mileTwo and finish times for the runner 
 */

         System.out.println("Enter Your First Name: ");
         firstName = in.nextLine();
         System.out.println("Enter Your Last Name: ");
         lastName = in.nextLine(); 
         System.out.println("Enter Your First Mile (mm:ss.sss): ");
         mileOne = in.nextLine();
         System.out.println("Enter Your Second Mile (mm:ss.sss): ");
         mileTwo = in.nextLine(); 
         System.out.println("Enter Your Time Finished (mm:ss.sss): ");
         finish = in.nextLine(); 
         
         splitTwo = subtractTime(mileTwo, mileOne); 
         splitThree = subtractTime(finish, mileTwo);

/**
 * display a sumary for the runner
 */

          System.out.println(firstName + " " + lastName);
          System.out.println("Split One: " + mileOne);
          System.out.println("Split Two: " + splitTwo);
          System.out.println("Split Three: " + splitThree);

    }

/**
 * @param endTime
 * @param startTime
 * @return the time 
 */

    private static String subtractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds (endTime); 
        double startTimeInSeconds = convertToSeconds (startTime); 

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds; 

        return convertToTime(diffInSeconds); 
    }

/**
 * @param timeInSeconds
 * @return the time in proper format (mm:ss.sss)
 */
    private static String convertToTime(double timeInSeconds) {
        return String.format("%d:%06.3f", getMinutes(timeInSeconds), getSeconds(timeInSeconds));
    }
    
/**
 * @param totalSeconds
 * @return this method uses the time (in seconds) and finds the seconds that are  left 
 * once converting it to minutes 
 */

    public static double getSeconds(double totalSeconds) {
        double second = (totalSeconds % 60);
        return second;
    }

/**
 * @param totalSeconds
 * @return this method uses the time (in seconds) and finds the minutes
 */

    public static int getMinutes(double totalSeconds) {
        int minute = (int)(totalSeconds/60);
        return minute;
    }

/**
 * @param time
 * @return rs the minutes and the seconds and the colon properly 
 */

    private static double convertToSeconds(String time) {
        int getColon = time.indexOf(":");
        double minute = Double.valueOf(time.substring(0 , getColon));
        double second = Double.valueOf(time.substring(0 , getColon));
        return (minute * 60) + second;
    }
}