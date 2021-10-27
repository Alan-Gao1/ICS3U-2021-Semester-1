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
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;
    private static final int TIE = 3;
    private static final int HIGH_CARD = 1;
    private static final int PAIR = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int STRAIGHT_FLUSH = 6;
 



    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("You wanna try and not kill an innocent human being and play hangman again?");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("YES")||answer.equals("Y")){
                return true;
            }else if(answer.equals("NO")||answer.equals("N")){
                return false;
            }else{
                System.out.println("Invalid input. It's pretty straightfoward. YES or NO answer. Get it right.");
            }
        }
        return false;
    }
    public static void main(String[] args) {
        final int MIN_BET = 50;
        final int MAX_BET = 100;
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        boolean playAgain = true;
        while(playAgain){
            playPokerHand(in, wallet, MIN_BET, MAX_BET);
            if(wallet>=MIN_BET*2)
                playAgain = playAgain(in);
            else
                System.out.println("you broke");
        }
    }

    private static boolean fold(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("You wanna keep betting your heard earned money (Y/N)? ");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("YES")||answer.equals("Y")){
                return false;
            }else if(answer.equals("NO")||answer.equals("N")){
                return true;
            }else{
                System.out.println("Invalid input. It's pretty straightfoward. YES or NO answer. Get it right.");
            }
        }
        return false;
    }
    private static int playPokerHand(Scanner in, int wallet, int minBet, int maxBet) {
        int bet = getBet(in, wallet, minBet, maxBet);
        String playerHand = "";
        String dealerHand = "";
        String usedCards = "";
        for(int i = 0; i<MAX_CARDS; i++){
            playerHand += getCard(playerHand);
        }
        usedCards += playerHand;
        for(int i = 0; i <MAX_CARDS; i++){
            dealerHand += getCard(playerHand);
        }
        System.out.println("Your hand: "+playerHand);
        System.out.println("Dealer Hand: "+dealerHand);
        if(!fold(in)){
            bet += getBet(in, wallet, minBet, maxBet);
            playerHand = discard(in, playerHand, usedCards);
            System.out.println("Your new hand: "+playerHand);
        }else{
            System.out.println("Player folds.");
            wallet -= bet;
        }
        if(compareHands(playerHand, dealerHand)==1){
            System.out.println("You won! Barely.");
            wallet += bet;
        }else if(compareHands(playerHand, dealerHand)==2){
            System.out.println("Dealer wins! WELL IF IT ISNT THE CONSEQUENCES OF YOUR OWN ACTIONS.");
            wallet -= bet;
        }else{
            System.out.println("SOMEHOW...YOU TIED.");
        }
        return wallet;
    }
    private static int compareHands(String playerHand, String dealerHand) {
        if(getHand(playerHand)>getHand(dealerHand)){
            return PLAYER_WINS;
        }else if(getHand(dealerHand)>getHand(playerHand)){
            return DEALER_WINS;
        }else{
            if(getHighCard(playerHand)>getHighCard(dealerHand)){
                return PLAYER_WINS;
            }else if (getHighCard(playerHand)<getHighCard(dealerHand)){
                return DEALER_WINS;
            }else{
                return TIE;
            }
        }
    }
    private static int getHand(String cards) {
        if(isFlush(cards)&&isStraight(cards)){
            return STRAIGHT_FLUSH;
        }else if(isFlush(cards)){
            return FLUSH;
        }else if(isStraight(cards)){
            return STRAIGHT;
        }else if(isThreeOfAKind(cards)){
            return THREE_OF_A_KIND;
        }else if(isPair(cards)){
            return PAIR;
        }else{
            return HIGH_CARD;
        }
    }
    private static boolean isFlush(String cards) {
        String c1s = cards.substring(1,2);
        String c2s = cards.substring(4,5);
        String c3s = cards.substring(6,7);
        if(c1s.equals(c2s)&&c2s.equals(c3s)){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isStraight(String cards) {
        int c1n = Integer.parseInt(cards.substring(0,1));
        int c2n = Integer.parseInt(cards.substring(3,4));
        int c3n = Integer.parseInt(cards.substring(5,6));
        if(c1n>c2n&&c2n>c3n){
            return true;
        }else if(c1n>c2n&&c3n>c2n){
            return true;
        }else if(c2n>c3n&&c3n>c1n){
            return true;
        }else if(c2n>c1n&&c1n>c3n){
            return true;
        }else if(c3n>c2n&&c2n>c1n){
            return true;
        }else if(c3n>c1n&&c1n>c2n){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isThreeOfAKind(String cards) {
        String c1n = cards.substring(0,1);
        String c2n = cards.substring(3,4);
        String c3n = cards.substring(5,6);
        if(c1n.equals(c2n)&&c2n.equals(c3n)){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isPair(String cards) {
        int c1n = Integer.parseInt(cards.substring(0,1));
        int c2n = Integer.parseInt(cards.substring(3,4));
        int c3n = Integer.parseInt(cards.substring(5,6));
        if(c1n==c2n){
            return true;
        }else if(c2n==c3n){
            return true;
        }else if(c1n==c3n){
            return true;
        }else{
            return false;
        }
    }
    private static int getHighCard(String cards) {
        int c1n = Integer.parseInt(cards.substring(0,1));
        int c2n = Integer.parseInt(cards.substring(3,4));
        int c3n = Integer.parseInt(cards.substring(5,6));
        return Math.max(Math.max(c1n, c2n), c3n);
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
