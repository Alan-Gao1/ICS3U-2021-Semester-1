package Week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        studentInput(in, 1);
        studentInput(in, 2);
        studentInput(in, 3);

        in.close();
    }
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
    public static double round(double num){
        num +=0.0005;
        num *= 1000;
        num = (int)num;
        num = (double)num;
        num /= 1000;
        return num;
    }
    public static double convertToSeconds(String time){
        int ind = time.indexOf(":");
        int minutes = Integer.parseInt(time.substring(0,ind));
        double remaining = Double.parseDouble(time.substring(ind+1));
        double total = (minutes*60)+remaining;
        return round(total);
    }
    public static void convertToTime(double time){
        double remainder = time%60;
        remainder = round(remainder);
        int minutes = (int)((time-remainder)/60);
        System.out.printf("%d:%06.3f", minutes, remainder);

    }
    public static double subtractTimes(String first, String second) {
        double difference = convertToSeconds(first)-convertToSeconds(second);
        return difference;
    }
}
