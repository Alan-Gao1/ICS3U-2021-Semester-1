package Week7;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final String DIAMONDS = "D";

    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final int MAX_CARDS = 3;
    private static final String CARDS = "AHACASAD2H2C2S2D3H3C3S3D4H4C4S4D5H5C5S5D6H6C6S6D7H7C7S7D8H8C8S8D9H9C9S9D10H10C10S10DJHJCJSJDQHQCQSQDKHKCKSKD";
    public static void main(String[] args) {
        final int MIN_BET = 50;
        final int MAX_BET = 100;
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        int bet = getBet(in, wallet, MIN_BET, MAX_BET);
        String playerHand = "";
        String usedCards = "";
        for(int i = 0; i<MAX_CARDS; i++){
            playerHand += getCard(playerHand);
        }
        usedCards += playerHand;
        System.out.println("Your hand: "+playerHand);
        playerHand = discard(in, playerHand, usedCards);
        System.out.println("Your new hand: "+playerHand);
    }

    private static String discard(Scanner in, String playerHand, String usedCards) {
        int toReplace = getNumber(in,"How many cards would you like to discard: ", 0, 3);
        String newHand = newHand(in, playerHand, toReplace, usedCards);
        return newHand;
    }

    private static String newHand(Scanner in, String playerHand, int toReplace, String usedCards) {
        boolean validInput = false;
        while(!validInput){
            try {
                if(toReplace==0){
                    validInput = true;
                }else if(toReplace==2){
                    System.out.print("Which card would you like to keep: ");
                    String input = in.nextLine().toUpperCase();
                    if(CARDS.indexOf(input)>=0 && playerHand.indexOf(input)>=0){
                        int ind = playerHand.indexOf(input);
                        String c1 = "";
                        String c2 = "";
                        if(ind==0){
                            c1 = playerHand.substring(3,6);
                            c2 = playerHand.substring(6);
                            playerHand = playerHand.substring(0,3);
                        }else if(ind==3){
                            c1 = playerHand.substring(0,3);
                            c2 = playerHand.substring(6);
                            playerHand = playerHand.substring(3,6);
                        }else{
                            c1 = playerHand.substring(0,3);
                            c2 = playerHand.substring(3,6);
                            playerHand = playerHand.substring(6);
                        }
                        usedCards = addUsed(c1, usedCards);
                        usedCards = addUsed(c2, usedCards);
                        playerHand += getCard(usedCards);
                        playerHand += getCard(usedCards);
                        validInput = true;
                    }else{
                        System.out.println("bruh give me an actual card");
                    }
                }else if(toReplace==1){
                    System.out.print("Which card do you want to get rid of: ");
                    String input = in.nextLine().toUpperCase();
                    if(CARDS.indexOf(input)>=0 && playerHand.indexOf(input)>=0){
                        int ind = playerHand.indexOf(input);
                        String c3 = "";
                        if(ind==0){
                            playerHand = playerHand.substring(3);
                            c3 = playerHand.substring(0,3);
                        }else if(ind==3){
                            playerHand = playerHand.substring(0,3)+playerHand.substring(6);
                            c3 = playerHand.substring(3,6);
                        }else{
                            playerHand = playerHand.substring(0,6);
                            c3 = playerHand.substring(6);
                        }
                        usedCards = addUsed(c3, usedCards);
                        playerHand += getCard(usedCards);
                        validInput = true;
                    }
                }else if(toReplace==3){
                    playerHand = "";
                    usedCards = addUsed("", usedCards);
                    playerHand += getCard(usedCards);
                    playerHand += getCard(usedCards);
                    playerHand += getCard(usedCards);
                    validInput = true;
                }else{
                    System.out.println("Invalid input.");
                }
            } catch (Exception ex) {
                System.out.println("good job you put an invalid input try again.");
            }
        }
        return playerHand;
    }

    private static String addUsed(String c, String usedCards) {
        return usedCards+c;
    }

    private static int getNumber(Scanner in, String prompt, int min,int max) {
        boolean validInput = false;
        int num = 0;
        while(!validInput){
            try{
                System.out.print(prompt);
                num = Integer.parseInt(in.nextLine());
                if(num<=max&&num>=min){
                    validInput = true;
                }else{
                    System.out.println("pick a number from 0 to 3 its basic math are you stupid");
                    validInput = false;
                }
            }catch(Exception ex){
                System.out.println("ENTER A NUMBER. TRY AGAIN.");
                validInput = false;
            }
        }
        return num;
    }

    private static String getCard(String cardsUsed) {
        String card = getFace() + getSuit();
        while(cardsUsed.indexOf(card)==0){
            card = getFace()+getSuit();
        }
        return card + " ";
    }

    private static String getSuit() {
        int suit = (int) (Math.random() *4);
        if(suit==0)
            return HEARTS;
        else if(suit == 1)
            return SPADES;
        else if(suit ==2)
            return CLUBS;
        else
            return DIAMONDS;
    }

    private static String getFace() {
        int face = (int)(Math.random()*13)+1;
        if(face>1&&face<11){
            return "" + face;
        }else if(face==1){
            return ACE;
        }else if(face==11){
            return JACK;
        }else if(face==12){
            return QUEEN;
        }else{{
            return KING;
        }}
    }

    private static int getBet(Scanner in, int wallet, int minbet, int maxbet) {
        boolean validInput = false;
        int bet = 0;
        while(!validInput){
            System.out.print("Please enter a wager: [" + minbet + "-" + maxbet+"]");
            try{
                bet = Integer.parseInt(in.nextLine());
                if(bet>wallet){
                    System.out.println("really dont got that much money. you only got: $"+wallet);
                }else if(bet<minbet||bet>maxbet){
                    System.out.println("Make a bet between "+minbet+" and "+maxbet);
                }else{
                    validInput = true;
                }
            }catch(Exception ex){
                System.out.println("Invalid bet. bruh");
            }
        }
        return bet;
    }
}
