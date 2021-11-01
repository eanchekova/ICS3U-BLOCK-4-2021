package week7;

import java.util.Scanner;

public class CrazyEights2 {
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
          System.out.println("Points \n player: " + playerPoints + "Computer Player 1: " + c1Points + "Computer Player 2: " + c2Points);
          if (playerPoints < c1Points && playerPoints < c2Points)
            System.out.println("You Win!");
          else if (c1Points < playerPoints && c1Points < c2Points)
            System.out.println("Computer 1 Wins");
          else if (c2Points < playerPoints && c2Points < c1Points)
            System.out.println("Computer 2 Wins");   
          else if(playerPoints == c1Points && playerPoints < c2Points)
            System.out.println("You and Computer 1 Tie");
          else if(playerPoints == c2Points && playerPoints < c1Points)
            System.out.println("You and Computer 2 Tie");
          else if(c1Points == c2Points && c1Points < playerPoints)
            System.out.println("Computer 1 and Computer 2 Tie");
      }

      //what card is what (ex. 10S, 4C, 8D, etc)
      private static String getCard() {
        String card = getFace() + getSuit();         
         return card; 
    }

    //the suit of the card (Spades, hearts, clubs, diamonds)
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

    //the face of the card (Queen, King, Ace, Jack)
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
    //Determines when the game is over 
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
   }

    //The game is played because of this method 
    private static String playRound() {
        Scanner in = new Scanner (System.in);
        String playerHand = ""; 
        String c1Hand = ""; 
        String c2Hand = ""; 
        String topCard = ""; 
        String initialTopCard = "";  
     
        topCard = getCard() + " "; 
        System.out.println("The top card is: " + topCard); 
     
       
        playerHand = getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";
               
        System.out.println("player hand: " + playerHand); 
        playerHand = processPlayer(in, playerHand, topCard); 
       
        c1Hand = getCard() + " ";
        c1Hand += getCard() + " ";
        c1Hand += getCard() + " ";
        c1Hand += getCard() + " ";
        c1Hand += getCard() + " ";
        
       
        System.out.println("Computer hand: " + c1Hand); 
       
        c2Hand = getCard() + " ";
        c2Hand += getCard() + " ";
        c2Hand += getCard() + " ";
        c2Hand += getCard() + " ";
        c2Hand += getCard() + " "; 
     
        System.out.println("Second Computer Hand: " + c2Hand); 
     
        while(playerHand.length() > 0 && c1Hand.length() > 0 && c2Hand.length() >= 0){ 
            String temp = processPlayer(in, playerHand, initialTopCard); 
            playerHand = temp.substring(0, temp.indexOf("-")); 
            topCard = temp.substring(temp.indexOf("-") + 1); 
     
            temp = processComputer(c1Hand, topCard, playerHand, c2Hand); 
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
     
            temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
            c2Hand = temp.substring(0, temp.indexOf("-")); 
            topCard = temp.substring(temp.indexOf("-") + 1);
        } 
        return playerTotal(playerHand, initialTopCard) + "-" + playerTotal(c1Hand, initialTopCard) 
        + playerTotal(c2Hand, initialTopCard); 
     }

   //The total points the player has 
    private static int playerTotal(String hand, String playerHand) {
        int score = 0; 
        for (int i = 0; i < hand.length(); i += 3){
        String face = hand.substring(i, i + 1); 
            if ("10JQK".indexOf(face) >= 0)
                score += 10;
            else if (face.equals("A"))
                score += 1; 
            else if ("2345679".indexOf(face) >= 0)
                score += Integer.parseInt(face);
            else
                score += 50;  
        }
        return score; 
    }

    //how the comuter plays
    /**
     * @param cHand - decides what to play
     * @param topCard to see what card it can play
     * @param c1Hand to see if other players have cards left
     * @param c2Hand to see if other players have cards left
     * @return
     */  
    private static String processComputer(String cHand, String topCard, String c1Hand, String c2Hand) {
        String topNum = topCard.substring(0, topCard.length()-1); 
        String topSuit = topCard.substring(topCard.length()-1);  
        String cardPlayed = "";
        int count = 0;
        int index = 0;
        String card = "";
        Boolean pickup = true;
    
        while(pickup && count <5){
           Boolean canPlay = (cHand.indexOf(topCard.substring(topCard.length()-1)) >=0) || (cHand.indexOf(topCard.substring(0,1))>=0)|| (cHand.indexOf(topCard.substring(0,2))>=0) || (cHand.indexOf("8")>=0);
           if(canPlay){
              pickup = false;
           }
           else{
            cHand += getCard() + " ";
              count++;
           }
        }
        if(count == 5){
           System.out.println("Skipped");
           return topCard + " " + cHand;
        }
    
           if(c1Hand.length() <= 4 || c2Hand.length() <= 4){ 
              while(cHand.indexOf(topNum, index) >= 0){
                 index = cHand.indexOf(topNum, index);
                 card = cHand.substring(index, cHand.indexOf(" ", index)); 
                 if(!card.equals(topCard)){
                    String cardReplace = card + " ";
                    return card + " " +  cHand.replace(cardReplace, "");
                 }
                 index ++;   
              }
              if(cHand.indexOf("8") >= 0){
                cHand = cHand.substring(0, cHand.indexOf("8")) + cHand.substring(cHand.indexOf("8") + 3); 
                 if(cHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
                    return "8H" + " " + cHand;
                 }if(cHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
                    return "8C" + " " + cHand;
                 }if(cHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
                    return "8D" + " " + cHand;
                 }if(cHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
                    return "8S" + " " + cHand;
                 }return "8" + topSuit + " " + cHand; 
         }
          if (cHand.indexOf(topSuit) >= 0){ 
             if(!cHand.substring(cHand.indexOf(topSuit) -1, cHand.indexOf(topSuit)).equals("8")){
                if(cHand.substring(cHand.indexOf(topSuit) - 1, cHand.indexOf(topSuit)).equals("0")){ 
                   cardPlayed = cHand.substring(cHand.indexOf("10"), cHand.indexOf("10") + 3);
                   cHand = cHand.substring(0, cHand.indexOf("10")) + cHand.substring(cHand.indexOf("10") + 4);
                   return cardPlayed + " " + cHand;
                }
                 cardPlayed = cHand.substring(cHand.indexOf(topSuit)-1, cHand.indexOf(topSuit)+1);
                 cHand = cHand.substring(0, cHand.indexOf(cardPlayed)) + cHand.substring(cHand.indexOf(cardPlayed) + 3);
                 return cardPlayed + " " + cHand;
            }
           }
           if(cHand.indexOf(topNum)>= 0){
              if(topNum.equals("10")){
                cardPlayed = cHand.substring(cHand.indexOf("10"), cHand.indexOf("10")+3);
                cHand = cHand.substring(0, cHand.indexOf("10")) + cHand.substring(cHand.indexOf("10") + 4);
                return cardPlayed + " " + cHand;
             }
              if (!cHand.substring(cHand.indexOf(topNum), cHand.indexOf(topNum) + 1).equals("8")){
               cardPlayed = cHand.substring(cHand.indexOf(topNum), cHand.indexOf(topNum) + 2);
               cHand = cHand.substring(0, cHand.indexOf(cardPlayed)) + cHand.substring(cHand.indexOf(cardPlayed) + 3);
               return cardPlayed + " " + cHand;
             }
    
          }
          if(cHand.indexOf("8") >= 0){
            cHand = cHand.substring(0, cHand.indexOf("8")) + cHand.substring(cHand.indexOf("8") + 3);
           if(cHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
              return "8H" + " " + cHand;
           }if(cHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
              return "8C" + " " + cHand;
           }if(cHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
              return "8D" + " " + cHand;
           }if(cHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
              return "8S" + " " + cHand;
           }return "8" + topSuit + " " + cHand;
        }
    
    
     return topCard + " " + cHand; 
           }
       return card;
    }

    //Determines if the player can put the card 
    private static String validHand(String playerHand, String topCard) {
        if (playerHand.length() == 0) {
            return "";
        } 
        int addedCards = 0; 
        while (playerHand.indexOf(topCard.substring(0, topCard.length() - 1)) == 1 && playerHand.indexOf(topCard.substring(topCard.length() - 1)) == -1 && playerHand.indexOf("8") == -1 ){
            playerHand += " " + getCard(); 
            addedCards ++; 
            if (addedCards == 5){
                return playerHand + " ";
            }
        }
        return playerHand + " ";
    }  
    /**
     * 
     * @param in the scanner that allows player to input what card
     * @param playerHand hand of the player
     * @param topCard sees the top card 
     * @return
     */
    private static String processPlayer(Scanner in, String playerHand, String topCard){
        boolean validInput = false; 
        playerHand += " "; 
        String card = " ";

        while (!validInput){ 
            System.out.println(playerHand); 
            System.out.println("Pick a Card"); 
            card = in.nextLine(); 
                if(playerHand.indexOf(card) >  - 1 && card.indexOf(" ") == -1){ 
                    if (card.indexOf(topCard.substring(topCard.length()-1)) >= 0 || card.indexOf(topCard.substring(0,topCard.length()-1)) >=0){ 
                        validInput = true; 
                    }
                else if(card.indexOf("8") > -1){ 
                    String suit = ""; 
                    System.out.println("Which suit do you want to change it to? (Please type in D, C, H, S)"); 
                    boolean isSuit = false; 
                        while(!isSuit){ 
                            suit = in.nextLine().toUpperCase();  
                                if(suit.equals("D") || suit.equals("C") || suit.equals("H") || suit.equals("S")){ 
                            }
                else{ 
                    System.out.println("invalid input"); 
                }
               }
                String newCard = "8" + suit; 
               return newCard + "-" + playerHand.replace(card + " ", "").trim(); 
           } 
       } 
            else {  
                System.out.println("Invalid Input.");  
       }
   }
   return card + "-" + playerHand.replace(card + " ", "").trim(); 
}
}

/**
 * please dont fail me
 * What's the difference between Java and JavaScript?
 * Java and JavaScript are similair in the same way car a carpet are.
 */