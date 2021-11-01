package week7;

import java.util.Scanner;
import java.util.Random; 

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    public static void main(String[] args) {
      Scanner in = new Scanner (System.in);
      String playerHand = " ";
      String c1Hand = " "; 
      String c2Hand = " "; 
      String topCard = " ";

      playerHand = getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";

      System.out.println(playerHand);

      c1Hand = getCard(c1Hand) + " ";
      c1Hand += getCard(c1Hand) + " ";
      c1Hand += getCard(c1Hand) + " ";
      c1Hand += getCard(c1Hand) + " ";
      c1Hand += getCard(c1Hand) + " ";

      System.out.println(c1Hand);

      c2Hand = getCard(c2Hand) + " ";
      c2Hand += getCard(c2Hand) + " ";
      c2Hand += getCard(c2Hand) + " ";
      c2Hand += getCard(c2Hand) + " ";
      c2Hand += getCard(c2Hand) + " ";

      System.out.println(c2Hand);

      int playerPoints = 0, c1Points = 0, c2Points = 0; 
        while (!gameOver(playerPoints, c1Points, c2Points)){
           String result = playRound();     
           int firstDash = result.indexOf("-"); 
           int secondDash = result.lastIndexOf("-");
           playerPoints += Integer.parseInt(result.substring(0, firstDash));
           c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
           c2Points += Integer.parseInt(result.substring(secondDash + 1));

           System.out.println("Current Score:" + playerPoints + " " + c1Points + " " + c2Points);
        }  
        
        

    }

    private static String playRound() {
       



       

       //while loop

       String temp = processPlayer (playerHand, topCard); 
       playerHand = temp.substring(0, temp.indexOf("-"));
       topCard = temp.substring(temp.indexOf("-") + 1);

       temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
       c1Hand = temp.substring(0, temp.indexOf("-"));
       topCard = temp.substring(temp.indexOf("-") + 1);

       temp = processComputer(c2Hand, topCard, playerHand, c1Hand); 
       c2Hand = temp.substring(0, temp.indexOf("-")); 
       topCard = temp.substring(temp.indexOf("-") + 1); 

       return "17-0-6";
   }

   private static String getCard(String playerHand) {
      String card = getFace() + getSuit(); 
         while (usedCards.indexOf(card) >= 0) {
            card = getFace() + getSuit(); 
         }
         return card; 
   }

   private static String processPlayer(String playerHand, String topCard) {
      return null;
   }

   private static String processComputer(String myHand, String topCard, String oppHand1, String oppHand2) {
      return null;
   }

   private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
      return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
   }

     private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
     }

     while (!validInput) {
        if(checkFace(playerHand, topCard) == true || checkSuit(playerHand, topCard) == true)
        System.out.println("Enter card you would like to play: ");
        
     }
  
     private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
  
     }
}
