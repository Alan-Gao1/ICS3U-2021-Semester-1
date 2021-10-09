package Week5;

import java.util.Scanner;

public class CrossCountry {
    /**
     * The main method calls the studentInput function 3 times for each student and intializes the scanner and closes it afterwards
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        studentInput(in, 1);
        studentInput(in, 2);
        studentInput(in, 3);

        in.close();
    }

    /**
     * This function takes in all the inputs from the user and calls the other functions to print the final results
     * @param in Scanner that takes input from the user
     * @param n The integer that indicates Student 1, 2, or 3
     */
    public static void studentInput(Scanner in, int n){
        System.out.print("Please enter your name: ");
        String name = in.nextLine();

        System.out.print("Please enter your time for the first kilometer in the formant [minutes:seconds.milliseconds]: ");
        String firstKilometer = in.nextLine();

        System.out.print("Please enter your time to the second kilometer in the same format: ");
        String secondKilometer = in.nextLine();

        System.out.print("Please enter your time for all 5km in identical format: ");
        String total = in.nextLine();
        
        System.out.print("\nStudent "+n+"\nName: "+ name + "\nTime for the first kilometer: "+firstKilometer + "\nTime for the second kilometer: ");
        convertToTime(subtractTimes(secondKilometer, firstKilometer));
        System.out.print("\nTime for the last 3 kilometers: ");
        convertToTime(subtractTimes(total, secondKilometer));
        System.out.print("\nTime for the entire race: " + total +"\n\n");
        System.out.print("Other stats (cause why not) \nAverage speed: " + round(5000/convertToSeconds(total)) + " m/s \nSpeed of fastest split: "+ Math.max(Math.max(round(1000/(convertToSeconds(secondKilometer) - convertToSeconds(firstKilometer))), round(3000/((convertToSeconds(total) - convertToSeconds(secondKilometer))))),round(1000/convertToSeconds(firstKilometer))));
        System.out.println(" m/s\n");
    }

    /**
     * roundes a double to the nearest hundreth
     * @param num - the number to be rounded
     * @return - returns the rounded number
     */
    public static double round(double num){
        num +=0.0005;
        num *= 1000;
        num = (int)num;
        num = (double)num;
        num /= 1000;
        return num;
    }

    /**
     * This method takes the inputed time in minutes:seconds.miliseconds and converts it to a double of just seconds and rounds it
     * @param time - takes the String of time to be converted
     * @return - returns the total seconds (e.g. 34.211)
     */
    public static double convertToSeconds(String time){
        int ind = time.indexOf(":");
        int minutes = Integer.parseInt(time.substring(0,ind));
        double remaining = Double.parseDouble(time.substring(ind+1));
        double total = (minutes*60)+remaining;
        return round(total);
    }

    /**
     * takes a time (e.g 29.381) and converts it back to the standard format which the user used
     * @param time - takes in the double of time
     * prints the time with printf to keep the same format
     */
    public static void convertToTime(double time){
        double remainder = time%60;
        remainder = round(remainder);
        int minutes = (int)((time-remainder)/60);
        System.out.printf("%d:%06.3f", minutes, remainder);

    }

    /**
     * subtracts two times after converting them into seconds through the convertToSeconds function
     * @param first - the first number
     * @param second - the second number
     * @return - returns the double that is first-second
     */
    public static double subtractTimes(String first, String second) {
        double difference = convertToSeconds(first)-convertToSeconds(second);
        return difference;
    }
}
