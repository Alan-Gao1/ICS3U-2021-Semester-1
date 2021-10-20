package Week7;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        while(playAgain){
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);
        }
    }
    //_ _ _ _ _ / _ _ / _ _ _ / _ _ _ _ _ _ _ / _ _ _ _ _ _ _ 
    //_ _ _ _ _ / _ _ / _ S _ / S _ _ _ _ _ _ / _ _ _ _ _ _ _
    //7 pieces for hangman 
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
    private static void play(String hint, Scanner in){
        String lettersUsed = "";
        int numPieces = 0;
        boolean gameOver = false;
        String availibleLetters = "A B C D E F G H I J K L M O P Q R S T U V W X Y Z";
        while(!gameOver){
            String encryptedHint = encryptHint(hint, lettersUsed);
            System.out.println(encryptedHint);
            String letter = getLetter(in, availibleLetters);
            lettersUsed+=letter;

            availibleLetters = availibleLetters.replace(letter, "_");
            if(hint.indexOf(letter)<0){
                numPieces++;
            }
            if(numPieces>0){
                drawHangman(numPieces);
            }
            if(numPieces==7){
                System.out.println("You lose. Get good.");
                gameOver = true;
            }else if(encryptHint(hint, lettersUsed).indexOf("_")<0){
                System.out.println("You won. good job I guess");
                gameOver = true;
            }
        }

    }

    private static String getLetter(Scanner in, String availibleLletters) {
        System.out.println("Availible Lettrs: \n"+availibleLletters);
        boolean validInput = false;
        String letter = "";
        while(!validInput){
            System.out.print("Please chooose a letter:");
            letter = in.nextLine().toUpperCase();
            if(letter.length()==1&&availibleLletters.indexOf(letter)>=0){
                validInput=true;
            }else{
                System.out.println("Invalid choice. Try again, it's really not that hard. Enter a single letter.");
                System.out.println("Availible Lettrs: \n"+availibleLletters);                
            }
        }
        return letter;
    }
    private static String encryptHint(String hint, String lettersUsed) {
        String result = "";
        for(int i = 0;i<hint.length();i++){
            String s = hint.substring(i, i+1);
            if(s.equals(" ")){
                result+="/ ";
            }else if (lettersUsed.indexOf(s)>=0) {
                result+=s + " ";
            }else{
                result += "_ ";
            }
        }
        return result;
    }
    private static void drawHangman(int numPieces){
        System.out.println();
        System.out.println("Hangman(the innocent person you are trying not to hang): ");
        if(numPieces ==7){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
            System.out.println("|  / \\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==6){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
            System.out.println("|  / ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==5){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
            System.out.println("|  ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==4){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   ");
            System.out.println("|  ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==3){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|");
            System.out.println("|   ");
            System.out.println("|  ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==2){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|   |");
            System.out.println("|   ");
            System.out.println("|  ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }else if(numPieces ==1){
            System.out.println("----");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| ");
            System.out.println("|   ");
            System.out.println("|  ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
    }
}