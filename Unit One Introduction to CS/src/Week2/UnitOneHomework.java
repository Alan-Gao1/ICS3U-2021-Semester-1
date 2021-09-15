package Week2;

public class UnitOneHomework {
    public static void main(String[] args) {
        double x = 3.5;
        System.out.println("Original number: "+x);
        System.out.println("Squared number: "+Math.pow(x, 2));

        double TotalScore = 82;
        double Score = 68;
        System.out.println("Percentage: "+(Score/TotalScore)*100);

        int num = 83749;
        int SecondNum = (num%10000)/1000;
        int FourthNum = (((num%10000)%1000)%100)/10;
        System.out.println(SecondNum*FourthNum);

        double Vi = 6.4;
        double a = 2.3;
        double t = 1.7;
        System.out.println(Vi+(a*t));

        double r = 4;
        double a1 = Math.PI*(Math.pow(r, 2));
        System.out.println(a1);

        double r1 = 4;
        double v = (4.0/3.0)*Math.PI*Math.pow(r1, 3);
        System.out.println(v);

        int a2 = 3;
        int b = 2;
        int c = 8;
        int x3 = 5;
        double y = a2*Math.pow(x3, 2)+b*x+c;
        System.out.println(y);

        int x1 = 4;
        int x2 = 5;
        int y1 = 0;
        int y2 = 3;
        double slope = (y2-y1)/(x2-x1);
        System.out.print(slope);

        double p = 34;
        double n = 13;
        double d = 3;
        double q = 14;
        double l = 3;
        double t1 = 2;
        double money = (p*0.01)+(n*0.05)+(d*0.1)+(q*0.25)+l+(t1*2);
        System.out.println(money);

        double a5 = -3;
        double b5 = 2;
        double c5 = 8;
        double x15= ((0-b5)+Math.sqrt(Math.pow(b5, 2)-4*a5*c5))/2*a5;
        double x25= ((0-b5)-Math.sqrt(Math.pow(b5, 2)-4*a5*c5))/2*a5;
        System.out.println(x15);
        System.out.println(x25);
        
    }
}
