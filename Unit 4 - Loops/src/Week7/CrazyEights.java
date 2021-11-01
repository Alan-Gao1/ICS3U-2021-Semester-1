package Week7;

import java.util.Scanner;

public class CrazyEights {
    // c1 = computer 1
    // c2 = computer 2
    // p1 = player 1
    // hand = their hand
    // score = their score
    // face = the face (e.g. A,2,3,4,5)
    // suit = the suit (e.g. H,C,S,D)
    private static final String VALID_CARDS = "AHACASAD2H2C2S2D3H3C3S3D4H4C4S4D5H5C5S5D6H6C6S6D7H7C7S7D8H8C8S8D9H9C9S9D10H10C10S10DJHJCJSJDQHQCQSQDKHKCKSKD";
    private static final String SUITS = "HCSD";
    private static int c1Score = 0;
    private static int c2Score = 0;
    private static int p1Score = 0;
    private static int drawn = 0;
    private static String c1Hand = "";
    private static String c2Hand = "";
    private static String p1Hand = "";
    // the top card
    private static String played = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        System.out.println("HELLO AND WELCOME TO CRAZY EIGHTS!\n----------------------------------------------");
        System.out.print("The rules of the games are as follows:\n1.You (and everyone else) will be dealt 5 cards at the beginning of the game, with the rest placed in the middle as the stock pile, and the top (non 8) card will be flipped up to become the top card\n2. Computer 1 and 2 will play their cards\n3. You will play your card. It must match either the suit or face of the top card or be an 8\n4. Up to 5 cards will be automatically drawn if you have no valid cards in your hand\n5. First to get rid of their cards wins");
        System.out.println("\n\nSome additional information:\n-Cards will represented as 2-3 characters. The face value will be 1-2 characters, and will represent either the number for first letter of the face. For example, Ace is A, 2 is 2, and King is K. The last character is the suit. H is hearts, C is clubs, S is spades, and D is diamonds. Therefore, 3D is a 3 of diamonds.\n-Your total score will be calculated after each turn, and when your score exceeds 100, the person with the least score wins");
        System.out.println("\nEnter anything to continue...have fun!");
        in.nextLine();
        // dealing 5 cards to each user
        intialSetup();
        boolean allHandsOne = true;
        // this while loop runs as long as every single hand as at least ONE card (allHandsOne) and as long as every single hand has a score below 100
        while((c1Score<100&&c2Score<100&&p1Score<100)&&allHandsOne){
            // Computer 1's turn
            if(counter%3==0){
                System.out.println("\n---------COMPUTER 1'S TURN---------");
                System.out.println("Top card: "+played);
                // finds the valid card in c1Hand, returns "NONE" if no card found
                String c1Play = cLogic(c1Hand, c2Hand, p1Hand, played);
                drawn = 0;
                // draws a card as long as there is no valid card. Stops at 5 cards drawn and returns "NONE"
                c1Play = drawUntilValid(drawn, c1Play, c1Hand, c2Hand, p1Hand, played, 1);
                // the code segment that process and modifies the hand when the play is not "NONE"
                if(!c1Play.equals("NONE")){
                    played = c1Play;
                    System.out.println("Computer 1 plays "+played);
                    // this runs if the play has a "10" and if it isnt "8"
                    if(isTen(c1Play)&&!played.substring(0,1).equals("8")){
                        c1Hand = c1Hand.substring(0,c1Hand.indexOf(played)) + c1Hand.substring(c1Hand.indexOf(played)+3);
                    // runs if its a valid card that is NOT an 8
                    }else if(!c1Play.equals("NONE")&&!played.substring(0,1).equals("8")){
                        c1Hand = c1Hand.substring(0,c1Hand.indexOf(played)) + c1Hand.substring(c1Hand.indexOf(played)+2);
                    // runs if it is an 8
                    }else if(played.substring(0,1).equals("8")){
                        System.out.println("Suit changed to "+played.substring(1,2));
                        c1Hand = c1Hand.substring(0,c1Hand.indexOf("8")) + c1Hand.substring(c1Hand.indexOf("8")+2);
                    }
                    // the above if loop removes the card from the hand
                }else if(drawn==5 && c1Play.equals("NONE")){
                    System.out.println("Computer 1 has no more cards to play. Moving on.");
                }
                c1Score = calculateScore(c1Hand);
            }else if(counter%3==1){
                // This code function is the same as above but for Computer 2
                System.out.println("\n---------COMPUTER 2'S TURN---------");
                System.out.println("Top card: "+played);
                String c2Play = cLogic(c2Hand, c1Hand, p1Hand, played);
                drawn = 0;
                c2Play = drawUntilValid(drawn, c2Play, c2Hand, c1Hand, p1Hand, played, 2);
                if(!c2Play.equals("NONE")){
                    played = c2Play;
                    System.out.println("Computer 2 plays "+played);
                    if(isTen(c2Play)&&!played.substring(0,1).equals("8")){
                        c2Hand = c2Hand.substring(0,c2Hand.indexOf(played)) + c2Hand.substring(c2Hand.indexOf(played)+3);
                    }else if(!c2Play.equals("NONE")&&!played.substring(0,1).equals("8")){
                        c2Hand = c2Hand.substring(0,c2Hand.indexOf(played)) + c2Hand.substring(c2Hand.indexOf(played)+2);
                    }else if(played.substring(0,1).equals("8")){
                        System.out.println("Suit changed to "+played.substring(1,2));
                        c2Hand = c2Hand.substring(0,c2Hand.indexOf("8")) + c2Hand.substring(c2Hand.indexOf("8")+2);
                    }
                }else if(drawn==5 && c2Play.equals("NONE")){
                    System.out.println("Computer 2 has no more cards to play. Moving on.");
                }
                c2Score = calculateScore(c2Hand);
            }else{
                System.out.println("\n---------PLAYER 1'S TURN---------");
                System.out.println("Top card: "+played);
                System.out.println("YOUR CURRENT HAND: "+p1Hand);
                drawn = 0;
                // this code will run if the number of cards is less than 5 and if there is NOT a valid card in your hand
                while(drawn<5&&!validInHand(p1Hand, played)){
                    System.out.println("\nYou do not have a valid card in your hand to play.");
                    System.out.println("Drawing a card...\n");
                    drawn++;
                    p1Hand += drawCard();
                    System.out.println("CURRENT CARD: "+played);
                    System.out.println("YOUR CURRENT HAND: "+p1Hand);
                }
                // as long as drawn >=5 (max num of cards NOT drawn) this code will take an input and check if it is valid, then set it as the top card
                if(!(drawn>4)){
                    System.out.print("Enter your play: ");
                    String play = in.nextLine();
                    play = getValidInput(play, in, played);
                    // code that checks if the card is an 8, and prompts the user for the wild suit
                    if(play.substring(0,1).equals("8")){
                        System.out.print("YOU played an 8! Please indicate the suit (H for hearts, C for clubs, S for Spades, D for Diamond): ");
                        String suit = getWildSuit(in);
                        played = play.substring(0, 1)+suit;
                    }else{
                        played = play;
                    }
                    int len = play.length();
                    int ind = p1Hand.indexOf(play);
                    // removes the play card from the hand
                    p1Hand = p1Hand.substring(0,ind)+p1Hand.substring(ind+len);
                }else{
                    System.out.println("You have drawn the max number of cards possible.");
                }
                p1Score = calculateScore(p1Hand);
            }
            // if any hand has less than 0 in score, it has no cards, so allHandsOne is false - one of the hands has <1 card
            if(c1Score<0||c2Score<0||p1Score<0){
                allHandsOne = false;
            }
            counter++;
        }
        winnerOut(c1Score, c2Score, p1Score);
        in.close();
    }

    /**
     * this method draws 5 cards per hand, and also draws random cards as long as the top card is an 8
     * also calculates the score to check if any is >100 for the main method
     */
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
        c1Score = calculateScore(c1Hand);
        c2Score = calculateScore(c2Hand);
        p1Score = calculateScore(p1Hand);
    }
    
    /**
     * Keeps drawing a cardas long as there isnt a valid card in curHand. This is for the computer
     * @param drawn 
     * @param curPlay - the current player's play
     * @param curHand - the current hand. can be c1Hand or c2Hand depending on int player
     * @param otherHand - the other hand. if curHand is c1Hand, otherHand is c2Hand
     * @param p1Hand - Player 1's hand
     * @param played - the current top card
     * @param player - indicates which computer player it is
     * @return
     */
    private static String drawUntilValid(int drawn, String curPlay, String curHand, String otherHand, String p1Hand, String played, int player) {
        // determines which hand it is
        if(player==1){
            curHand = c1Hand;
        }else{
            curHand = c2Hand;
        }
        // runs as long as there is no invalid card and drawn cards <5
        while(curPlay.equals("NONE")&&drawn<5){
            curHand += drawCard();
            // tries to find a card. returns NONE if cannot
            curPlay = cLogic(curHand, otherHand, p1Hand, played);
            drawn++;
            System.out.println("Computer "+player+" draws a card.");
        }
        // resets the hands to the modified hands as modified by cLogic
        if(player==1){
            c1Hand = curHand;
        }else{
            c2Hand = curHand;
        }
        return curPlay;
    }

    /**
     * checks who is the winner and prints out the winning stats and who won
     * @param c1Score - Score of Computer 1
     * @param c2Score - Score of Computer 2
     * @param p1Score - Score of Player 1
     */
    private static void winnerOut(int c1Score, int c2Score, int p1Score) {
        // finds the lowest score
        int winner = Math.min(c1Score, Math.min(c2Score, p1Score));
        // checks which of the scores is equal to the lowest score
        if(winner==c1Score){
            System.out.println("\n-----------------------------------\nCOMPUTER ONE HAS WON!");
            System.out.println("--------------------\nOTHER HANDS:");
            System.out.println("Computer 2's Hand: "+c2Hand);
            System.out.println("Your Hand: "+p1Hand+"\n--------------------\nSCORES:");
            System.out.println("Computer 2's Score: "+c2Score);
            System.out.println("Your Score: "+p1Score);
            if(c1Score>0){
                System.out.println("Computer 1's (winning) score: "+p1Score);
            }
        }else if(winner==c2Score){
            System.out.println("\n-----------------------------------\nCOMPUTER TWO HAS WON!");
            System.out.println("--------------------\nOTHER HANDS:");
            System.out.println("Computer 1's Hand: "+c1Hand);
            System.out.println("Your Hand: "+p1Hand+"\n--------------------\nSCORES:");
            System.out.println("Computer 1's Score: "+c1Score);
            System.out.println("Your Score: "+p1Score);
            if(c2Score>0){
                System.out.println("Computer 2's (winning) score: "+p1Score);
            }
        }else{
            System.out.println("\n-----------------------------------\nYOU (THE PLAYER) HAS WON! CONGRATULATIONS! YOU HAVE WON THIS COMPLETLY USELESS PRIZE!");
            System.out.println("**********");
            System.out.println("*CONGRATS*");
            System.out.println("**********");
            System.out.println("--------------------\nOTHER HANDS:");
            System.out.println("Computer 1's Hand: "+c1Hand);
            System.out.println("Computer 2's Hand: "+c2Hand+"\n--------------------\nSCORES:");
            System.out.println("Computer 1's Score: "+c1Score);
            System.out.println("Computer 2's Score: "+c2Score);
            if(p1Score>0){
                System.out.println("Your (winning) score: "+p1Score);
            }
        }
    }

    /**
     * takes in a Wild Suit when the played card by the player is an 8
     * @param in - scanner to take an input
     * @return
     */
    private static String getWildSuit(Scanner in) {
        String suit = in.nextLine();
        boolean validSuit = false;
        while(!validSuit){
            // checks if the inputted suit is part of the valid suits (SUITS)
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

    /**
     * checks to make sure the user input is a valid play and loops while it is not
     * @param play - the user's play
     * @param in - input
     * @param played - the top card
     * @return
     */
    private static String getValidInput(String play, Scanner in, String played) {
        boolean isValid = false;
        // p = played (top card)
        String pface = findFace(played);
        String psuit = findSuit(played);
        // play = play (the player's play)
        String playFace = findFace(play);
        String playSuit = findSuit(play);
        while(!isValid){
            if(VALID_CARDS.indexOf(play)<0){
                System.out.println("Not a valid card. Must have a real face and real suit value.");
            }else if(p1Hand.indexOf(play)<0){
                System.out.println("Card not in hand. Try again.");
            }else if(!(pface.equals(playFace)||psuit.equals(playSuit))&&!playFace.equals("8")){
                System.out.println("Not a valid play. Must have a matching face, suit or be an 8.");
            // this is just hard coding an edge case :/
            }else if(playFace.equals(playSuit)){
                System.out.println("Not a valid play.");
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

    /**
     * returns the suit of the card
     * @param card - the card to find the suit of
     * @return
     */
    private static String findSuit(String card) {
        if(card.length()>0)
            return card.substring(card.length()-1);
        else
            return "";
    }

    /**
     * returns the face of the card
     * @param card - the card to find the face of
     * @return
     */
    private static String findFace(String card) {
        if(isTen(card)){
            return "10";
        }else if(card.length()>0){
            return card.substring(0,1);
        }else{
            return "";
        }
    }

    /**
     * find the score of the hand
     * @param hand - the hand
     * @return
     */
    private static int calculateScore(String hand){
        // resets score each time so that when a user has no cards, their score will be the lowest possible and to keep it consistent
        int score = 0;
        for(int i = 0; i<hand.length(); i++){
            String cur = hand.substring(i, i+1);
            // checks every character in the hand for a matching face and adds the according score
            // if there is a "1" then its a 10; so add 10
            if(cur.equals("1")){
                score+=10;
            }else if(cur.equals("K")||cur.equals("Q")||cur.equals("J")){
                score+=10;
            }else if(cur.equals("9")||cur.equals("7")||cur.equals("6")||cur.equals("5")||cur.equals("4")||cur.equals("3")||cur.equals("2")){
                int num = Integer.parseInt(cur);
                score += num;
            }else if(cur.equals("8")){
                score +=50;
            }else if(cur.equals("A")){
                score++;
            }
        }
        if(hand.length()==0){
            score = -1;
        }
        return score;
    }

    /**
     * returns true if there is a valid card in the players hand
     * @param p1Hand
     * @param played
     * @return
     */
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

    /**
     * executes the 4 rules of the crazy eights game and attempts to find and get a valid play to the top card. Will return "NONE" if no valid card is found
     * @param curHand - the computer hand to check
     * @param otherHand - the other computer hand
     * @param p1Hand - the player's hand
     * @param played - the top card
     * @return
     */
    private static String cLogic(String curHand, String otherHand, String p1Hand, String played) {
        String playedFace = played.substring(0,played.length()-1);
        String playedSuit = played.substring(played.length()-1);
        String tempPlay = "";
        // rule 4
        if((otherHand.length()<4||p1Hand.length()<4)&&(faceIn(played, curHand)||eightIn(curHand))){
            // checks for face in in rule 4
            if(faceIn(played, curHand)){
                if(tenIn(curHand)){
                    tempPlay = curHand.substring(curHand.indexOf("10"), curHand.indexOf("10")+3);
                }else{
                    tempPlay = curHand.substring(curHand.indexOf(playedFace), curHand.indexOf(playedFace)+2);
                }
            // checks for the 8 in rule 4
            }else if(eightIn(curHand)){
                tempPlay = curHand.substring(curHand.indexOf("8"), curHand.indexOf("8")+1);
                tempPlay += cWildSuit(curHand);
            }
        // rule 1
        }else if(suitIn(played, curHand)){
            int ind = curHand.indexOf(playedSuit);
            // normal suit play
            if(!curHand.substring(ind-1, ind).equals("8")&&!curHand.substring(ind-1, ind).equals("0")){
                tempPlay = curHand.substring(ind-1, ind+1);
            // plays the first suit that is a 10
            }else if(!curHand.substring(ind-1, ind).equals("8")){
                tempPlay = curHand.substring(ind-2, ind+1);
            // if first matching suit is an 8
            }else if(curHand.substring(ind-1, ind).equals("8")){
                String tempHand = curHand;
                // removes all the 8 cards in the hand
                while(tempHand.indexOf("8")>=0){
                    tempHand = tempHand.substring(0,tempHand.indexOf("8"))+tempHand.substring(tempHand.indexOf("8")+2);
                }
                // rechecks hand for non-8 matching suit cards
                if(suitIn(played, tempHand)){
                    ind = tempHand.indexOf(playedSuit);
                    if(!tempHand.substring(ind-2, ind).equals("10")){
                        tempPlay = tempHand.substring(ind-1, ind+1);
                    }else{
                        tempPlay = tempHand.substring(ind-2, ind+1);
                    }
                }else{
                    tempPlay = "NONE";
                }
            }
        // rule 2
        // logic is similar to code segment above
        }else if(faceIn(played, curHand)){
            int ind = curHand.indexOf(playedFace);
            if(!curHand.substring(ind,ind+1).equals("8")&&!curHand.substring(ind+1, ind+2).equals("0")){
                tempPlay = curHand.substring(ind, ind+2);
            }else if(!curHand.substring(ind,ind+1).equals("8")){
                tempPlay = curHand.substring(ind, ind+3);
            }else if(curHand.substring(ind, ind+1).equals("8")){
                String tempHand = curHand;
                while(tempHand.indexOf("8")>=0){
                    tempHand = tempHand.substring(0,tempHand.indexOf("8"))+tempHand.substring(tempHand.indexOf("8")+2);
                }
                if(faceIn(played, tempHand)){
                    ind = tempHand.indexOf(playedFace);
                    if(!tempHand.substring(ind+1, ind+2).equals("0")){
                        tempPlay = tempHand.substring(ind, ind+2);
                    }else{
                        tempPlay = tempHand.substring(ind, ind+1);
                    }
                }else{
                    tempPlay = "NONE";
                }
            }
        // rule 3
        // checks if there is an eight, and if so, takes the 8 out of the hand and gets a valid suit in hand and plays it
        }else if(eightIn(curHand)){
            tempPlay = curHand.substring(curHand.indexOf("8"), curHand.indexOf("8")+1);
            tempPlay += cWildSuit(curHand);
        // otherwise, returns "NONE" to signify no valid card in hand
        }else{
            tempPlay = "NONE";
        }
        return tempPlay;
    }
    /**
     * returns a random suit that is in the hand
     * @param curHand - the hand
     * @return
     */
    private static String cWildSuit(String curHand) {
        boolean validSuit = false;
        int ind = (int)(Math.random()*4);
        String ans = "";
        while(!validSuit){
            // takes a random index of SUITS and if that suit is in the hand, it will play that suit
            if(curHand.indexOf(SUITS.substring(ind, ind+1))>=0){
                ans = SUITS.substring(ind, ind+1);
                validSuit = true;
            }else{
                ind = (int)(Math.random()*4);
            }
        }
        return ans;
    }

    /**
     * checks if there is a ten card in the hand
     * @param curHand - the hand
     * @return
     */
    private static boolean tenIn(String curHand) {
        if(curHand.indexOf("10")>=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * checks if there is an eight card in the hand
     * @param curHand - the hand
     * @return
     */
    private static boolean eightIn(String curHand) {
        if(curHand.indexOf("8")>=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * checks if the face of card is in hand
     * @param card
     * @param hand
     * @return
     */
    private static boolean faceIn(String card, String hand) {
        if(isTen(card)){
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

    /**
     * checks if the suit of card is in hand
     * @param card
     * @param hand
     * @return
     */
    private static boolean suitIn(String card, String hand) {
        if(hand.indexOf(card.substring(card.length()-1))>=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * checks if the card is a ten card
     * @param card
     * @return
     */
    private static boolean isTen(String card) {
        if(card.length()==3){
            return true;
        }else{
            return false;
        }
    }

    /**
     * draws a random card from getFace() and getSuit()
     * @return
     */
    private static String drawCard() {
        String face = getFace();
        String suit = getSuit();
        String card = face+suit;
        return card;
    }

    /**
     * gets a random suit
     * @return
     */
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

    /**
     * gets a random face
     * @return
     */
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