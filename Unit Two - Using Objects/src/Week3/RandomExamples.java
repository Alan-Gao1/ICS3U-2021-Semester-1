package Week3;

public class RandomExamples {
    public static void main(String[] args) {
        double r = Math.random();
        //System.out.print(r); //random number between 0.0 to 1.0 not including 1.0

        //random between bounds
        int lower = -5;
        int upper = 5;

        String str = "Random numbers";

        //change a random characterin the string to x

        int index = (int)(Math.random()*str.length());

        str = str.substring(0, index)+"x"+str.substring(index+1);
        System.out.println(str);
    }
}
