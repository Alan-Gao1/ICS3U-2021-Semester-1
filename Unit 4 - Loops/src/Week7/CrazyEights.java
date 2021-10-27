package Week7;

import java.util.Scanner;

public class CrazyEights {
    private static final String VALID_CARDS = "AHACASAD2H2C2S2D3H3C3S3D4H4C4S4D5H5C5S5D6H6C6S6D7H7C7S7D8H8C8S8D9H9C9S9D10H10C10S10DJHJCJSJDQHQCQSQDKHKCKSKD";
    private static final String SUITS = "HCSD";
    private static int c1Score = 0;
    private static int c2Score = 0;
    private static int p1Score = 0;
    private static int drawn = 0;
    private static String c1Hand = "";
    private static String c2Hand = "";
    private static String p1Hand = "";
    private static String played = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        int winner = 0;
        intialSetup();
        boolean allHandsOne = true;
        while((c1Score<100&&c2Score<100&&p1Score<100)&&allHandsOne){
            if(counter%3==0){
                System.out.println("\n---COMPUTER 1'S TURN---");
                System.out.println("Top card: "+played);
                String c1Play = cLogic(c1Hand, c2Hand, p1Hand, played);
                drawn = 0;
                c1Play = drawUntilValid(drawn, c1Play, c1Hand, c2Hand, p1Hand, played, 1);
                if(!c1Play.equals("NONE")){
                    played = c1Play;
                    System.out.println("Computer 1 plays "+played);
                    int ind = c1Hand.indexOf(played);
                    if(isTen(c1Play)){
                        c1Hand = c1Hand.substring(0,ind) + c1Hand.substring(ind+3);
                    }else if(!c1Play.equals("NONE")){
                        c1Hand = c1Hand.substring(0,ind) + c1Hand.substring(ind+2);
                    }
                }else if(drawn==5 && c1Play.equals("NONE")){
                    System.out.println("Computer 1 has no more cards to play. Moving on.");
                }
                c1Score = calculateScore(c1Hand);
                System.out.println(c1Score);
            }else if(counter%3==1){
                System.out.println("\n---COMPUTER 2'S TURN---");
                System.out.println("Top card: "+played);
                String c2Play = cLogic(c2Hand, c1Hand, p1Hand, played);
                drawn = 0;
                c2Play = drawUntilValid(drawn, c2Play, c2Hand, c1Hand, p1Hand, played, 2);
                if(!c2Play.equals("NONE")){
                    played = c2Play;
                    System.out.println("Computer 2 plays "+played);
                    int ind = c2Hand.indexOf(played);
                    if(isTen(c2Play)){
                        c2Hand = c2Hand.substring(0,ind) + c2Hand.substring(ind+3);
                    }else if(!c2Play.equals("NONE")){
                        c2Hand = c2Hand.substring(0,ind) + c2Hand.substring(ind+2);
                    }
                }else if(drawn==5 && c2Play.equals("NONE")){
                    System.out.println("Computer 2 has no more cards to play. Moving on.");
                }
                c2Score = calculateScore(c2Hand);
                System.out.println(c2Score);
            }else{
                System.out.println("\n---PLAYER 1'S TURN---");
                System.out.println("Top card: "+played);
                System.out.println("YOUR CURRENT HAND: "+p1Hand);
                drawn = 0;
                while(drawn<5&&!validInHand(p1Hand, played)){
                    System.out.println("You do not have a valid card in your hand to play.");
                    drawn++;
                    p1Hand += drawCard();
                    System.out.println("CURRENT CARD: "+played);
                    System.out.println("YOUR CURRENT HAND: "+p1Hand);
                }
                if(!(drawn>4)){
                    System.out.print("Enter your play: ");
                    String play = in.nextLine();
                    play = getValidInput(play, in, p1Hand, played);
                    if(play.substring(0,1).equals("8")){
                        System.out.print("YOU played an 8! Please indicate the suit (H for hearts, C for clubs, S for Spades, D for Diamond): ");
                        String suit = getWildSuit(in);
                        if(isTen(played)){
                            played = played.substring(0,2)+suit;
                        }else{
                            played = played.substring(0,1)+suit;
                        }
                    }else{
                        played = play;
                    }
                    int len = play.length();
                    int ind = p1Hand.indexOf(play);
                    p1Hand = p1Hand.substring(0,ind)+p1Hand.substring(ind+len);
                }else{
                    System.out.println("You have drawn the max number of cards possible.");
                }
                p1Score = calculateScore(p1Hand);
                System.out.println(p1Score);
            }
            if(c1Score<0||c2Score<0||p1Score<0){
                allHandsOne = false;
            }
            counter++;
        }
        winnerOut(c1Score, c2Score, p1Score, winner);
        in.close();
    }
    private static void intialSetup() {
        for(int i = 0; i<5; i++){
            c1Hand += drawCard();
            c2Hand += drawCard();
            p1Hand += drawCard();
        }
        played = drawCard();
        while(played.substring(0,1).equals("8")){
            played = drawCard();
        }
    }
    private static String drawUntilValid(int drawn, String curPlay, String curHand, String otherHand, String p1Hand, String played, int player) {
        if(player==1){
            curHand = c1Hand;
        }else{
            curHand = c2Hand;
        }
        while(curPlay.equals("NONE")&&drawn<5){
            curHand += drawCard();
            // hand doesnt save changes outside of this method
            curPlay = cLogic(curHand, otherHand, p1Hand, played);
            // global variable for c1Hand and c2Hand and pass in an integer to indicate which and which to draw in this function
            drawn++;
            System.out.println("Computer "+player+" draws.");
        }
        if(player==1){
            c1Hand = curHand;
        }else{
            c2Hand = curHand;
        }
        return curPlay;
    }
    private static void winnerOut(int c1Score, int c2Score, int p1Score, int winner) {
        winner = Math.min(c1Score, Math.min(c2Score, p1Score));
        if(winner==c1Score){
            System.out.println("COMPUTER ONE HAS WON!");
        }else if(winner==c2Score){
            System.out.println("COMPUTER TWO HAS WON!");
        }else{
            System.out.println("YOU (THE PLAYER) HAS WON! CONGRATULATIONS! YOU HAVE WON THIS COMPLETLY USELESS PRIZE!");
            System.out.println("**********");
            System.out.println("*CONGRATS*");
            System.out.println("**********");
        }
    }
    private static String getWildSuit(Scanner in) {
        String suit = in.nextLine();
        boolean validSuit = false;
        while(!validSuit){
            if(SUITS.indexOf(suit)>=0){
                validSuit = true;
            }else{
                System.out.println("Not a valid suit.");
                System.out.print("Input a valid suit. Ya better not do it wrong: ");
                suit = in.nextLine();
            }
        }
        return suit;
    }
    private static String getValidInput(String play, Scanner in, String p1Hand, String played) {
        boolean isValid = false;
        String pface = findFace(played);
        String psuit = findSuit(played);
        String playFace = findFace(play);
        String playSuit = findSuit(play);
        while(!isValid){
            if(VALID_CARDS.indexOf(play)<0){
                System.out.println("Not a valid card. Must have a real face and real suit value.");
            }else if(p1Hand.indexOf(play)<0){
                System.out.println("Card not in hand. Try again.");
            }else if(!(pface.equals(playFace)||psuit.equals(playSuit))&&!playFace.equals("8")){
                System.out.println("Not a valid play. Must have a matching face, suit or be an 8.");
            }else{
                isValid = true;
            }
            if(!isValid){
                System.out.print("Enter your play: ");
                play = in.nextLine();
                playFace = findFace(play);
                playSuit = findSuit(play);
            }
        }
        return play;
    }
    private static String findSuit(String card) {
        if(card.length()>0)
            return card.substring(card.length()-1);
        else
            return "";
    }
    private static String findFace(String card) {
        if(isTen(card)){
            return "10";
        }else if(card.length()>0){
            return card.substring(0,1);
        }else{
            return "";
        }
    }
    private static int calculateScore(String hand){
        int score = 0;
        for(int i = 0; i<hand.length(); i++){
            String currentChar = hand.substring(i,i+1);
            if(currentChar.equals("K")||currentChar.equals("Q")||currentChar.equals("J")){
                score += 10;
            }else if(currentChar.equals("10")){
                score += 10;
                i++;
            }else if(currentChar.equals("A")){
                score += 1;
            }else if(currentChar.equals("2")||currentChar.equals("3")||currentChar.equals("4")||currentChar.equals("5")||currentChar.equals("6")||currentChar.equals("7")||currentChar.equals("8")||currentChar.equals("9")){
                score += Integer.parseInt(currentChar);
            }else if(currentChar.equals("H")||currentChar.equals("C")||currentChar.equals("S")||currentChar.equals("D")){
                score++;
                score--;
            }else if(currentChar.equals("0")){
                score += 0;
            }
        }
        if(hand.length()==0){
            score = -1;
        }
        return score;
    }
    private static boolean validInHand(String p1Hand, String played) {
        int plength = played.length();
        String playedSuit = played.substring(plength-1);
        String playedFace = played.substring(0, plength-1);
        boolean validInHand = false;
        for(int i = 0; i<p1Hand.length(); i++){
            if(p1Hand.substring(i,i+1).equals(playedSuit) || p1Hand.substring(i,i+1).equals(playedFace) || p1Hand.substring(i,i+1).equals("8")){
                validInHand = true;
            }
        }
        return validInHand;
    }
    private static String cLogic(String curHand, String otherHand, String p1Hand, String played) {
        String pface = "";
        String psuit = played.substring(played.length()-1);
        String tempPlay = "";
        boolean faceIn = faceIn(played, curHand, isTen(played));
        boolean suitIn = suitIn(played, curHand);
        String tempHand = curHand;
        boolean isEight = false;
        if((otherHand.length()<4||p1Hand.length()<4)&&(curHand.indexOf("8")>=0||faceIn)){
            if(isTen(played)){
                pface = played.substring(0,2);
            }else{
                pface = played.substring(0,1);
            }
            if(faceIn){
                if(isTen(played)){
                    tempPlay = curHand.substring(curHand.indexOf("10"), curHand.indexOf("10")+3);
                }else{
                    tempPlay = curHand.substring(curHand.indexOf(pface), curHand.indexOf(pface)+2);
                }
            }else{
                tempPlay = curHand.substring(curHand.indexOf("8"), curHand.indexOf("8")+2);
            }
        }else if(suitIn){
            int ind = curHand.indexOf(psuit);
            if(curHand.substring(ind-1,ind).equals("0")){
                tempPlay = curHand.substring(ind-2, ind+1);
            }else{
                tempPlay = curHand.substring(ind-1, ind+1);
            }
            if(tempPlay.indexOf("8")>=0){
                isEight = true;
                while(isEight){
                    if(isTen(played)){
                        tempHand = tempHand.substring(0,tempHand.indexOf(tempPlay)) + tempHand.substring(tempHand.indexOf(tempPlay)+3);
                    }else{
                        tempHand = tempHand.substring(0,tempHand.indexOf(tempPlay)) + tempHand.substring(tempHand.indexOf(tempPlay)+2);
                    }
                    ind = tempHand.indexOf(psuit);
                    if(ind == -1){
                        tempPlay = "NONE";
                    }else if(isTen(played)){
                        tempPlay = tempHand.substring(ind-2, ind+1);
                    }else{
                        tempPlay = tempHand.substring(ind-1, ind+1);
                    }
                    if(tempPlay.indexOf("8")<0){
                        isEight = false;
                    }
                }
            }
        }else if(faceIn){
            int ind = 0;
            if(isTen(played)){
                pface = played.substring(0,2);
            }else{
                pface = played.substring(0,1);
            }
            ind = curHand.indexOf(pface);
            if(isTen(played)){
                tempPlay = curHand.substring(ind, ind+3);
            }else{
                tempPlay = curHand.substring(ind, ind+2);
            }
            if(tempPlay.indexOf("8")>=0){
                isEight = true;
                while(isEight){
                    if(isTen(played)){
                        tempHand = tempHand.substring(0,ind)+tempHand.substring(ind+3);
                    }else{
                        tempHand = tempHand.substring(0,ind) + tempHand.substring(ind+2);
                    }
                    ind = tempHand.indexOf(pface);
                    if(ind == -1){
                        tempPlay = "NONE";
                    }else if(isTen(played)){
                        tempPlay = tempHand.substring(ind, ind+3);
                    }else{
                        tempPlay = tempHand.substring(ind, ind+2);
                    }
                    if(tempPlay.indexOf("8")<0){
                        isEight = false;
                    }
                }
            }
        }else if(curHand.indexOf("8")>=0){
            int ind = curHand.indexOf("8");
            tempPlay = curHand.substring(ind,ind+2);
        }else{
            tempPlay = "NONE";
        }
        return tempPlay;
    }
    private static boolean faceIn(String card, String hand, boolean ten) {
        if(ten){
            if(hand.indexOf("10")>=0){
                return true;
            }else{
                return false;
            }
        }else{
            if(hand.indexOf(card.substring(0,1))>=0){
                return true;
            }else{
                return false;
            }
        }
    }
    private static boolean suitIn(String card, String hand) {
        if(hand.indexOf(card.substring(card.length()-1))>=0){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isTen(String card) {
        if(card.length()==3){
            return true;
        }else{
            return false;
        }
    }
    private static String drawCard() {
        String face = getFace();
        String suit = getSuit();
        String card = face+suit;
        return card;
    }
    private static String getSuit() {
        int suit = (int)(Math.random()*4);
        String s = "";
        if(suit==0){
            s = "H";
        }else if(suit==1){
            s = "C";
        }else if(suit==2){
            s = "S";
        }else{
            s = "D";
        }
        return s;
    }
    private static String getFace() {
        int face = (int)(Math.random()*13)+1;
        String f = "";
        if(face==1){
            f = "A";
        }else if(face==11){
            f = "J";
        }else if(face==12){
            f = "Q";
        }else if(face==13){
            f = "K";
        }else{
            f = Integer.toString(face);
        }
        return f;
    }
}