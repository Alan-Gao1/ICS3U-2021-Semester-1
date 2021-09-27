package Week2.Week3;

public class PracticeProblems {
    public static void main(String[] args) {
        questionA();
        question5();
        questionB();
        questionC();
        System.out.println(questionD(1, 2));
        System.out.println(questionE("ufhskdjhflke"));
        System.out.println(questionF("coolio", "ol"));
        System.out.println(questionG("sdlfho", "a"));
        System.out.println(questionH(2, 3, 6, -4));
        System.out.println(questionI(3.2, 54.1));
        System.out.println(questionJ("ABCDEFGH"));
        question1();
        question2();
        question3();
        question4();
        question6();
        question7();
        question8(23.3);
        question9(229);
        question10(3, 4);
        System.out.println(question11(3.1, 5.8)+" J");
    }
    public static double roundTenth(double n){
        n += 0.05;
        n *= 10;
        n = (int)n;
        n = (double)n;
        n /= 10;
        return n;
    }
    public static double roundHundredth(double n){
        n += 0.005;
        n *= 100;
        n = (int)n;
        n = (double)n;
        n /= 100;
        return n;
    }
    public static void questionA(){
        int num = (int)(Math.random()*100)+1;
        System.out.println(num);
    }
    public static void question5(){
        int totalGames = 110+44;
        System.out.println(((double)((int)(((double)110/totalGames)*1000)))/10);
    }
    public static void questionB(){
        int num = (int) (Math.random()*100)-50;
        System.out.println(num);
    }
    public static void questionC(){
        int num = (int)(Math.random()*6)+1;
        System.out.println(num);
    }
    public static int questionD(int s, int b){
        int num = (int)(Math.random()*(b-s+1))+s;
        return num;
    }
    public static String questionE(String str){
        int ind = str.indexOf("e");
        String str1 = str.substring(0,ind);
        String str2 = str.substring(ind+1);
        return str1+str2;
    }
    public static String questionF(String str, String sub){
        int ind = str.indexOf(sub);
        String str1 = str.substring(0, ind);
        String str2 = str.substring(ind+sub.length());
        return str1+str2;
    }
    public static int questionG(String str1, String str2){
        return str1.length()+str2.length();
    }
    public static double questionH(int x1, int y1, int x2, int y2){
        double yChange = y2-y1;
        double xChange = x2-x1;
        return yChange/xChange;
    }
    public static double questionI(double r, double h){
        final double PI = Math.PI;
        double volume = PI*Math.pow(r, 2)*h;
        //going to round to 2 decimal places cause why not
        volume += 0.005;
        volume *= 100;
        volume = (int)volume;
        volume /=100;
        return volume;
    }
    public static String questionJ(String str){
        int rand = (int)(Math.random()*(str.length()));
        String str1 = str.substring(0, rand);
        String str2 = str.substring(rand+1);
        return str1+str2;
    }
    public static void question1(){
        System.out.println(985.0*1.055);
    }
    public static void question2(){
        double area = ((4.5*2.32)+0.05)*10;
        area = (int)(area);
        area = ((double)area)/10;
        double perim = 4.5+4.5+2.3+2.3;
        perim += 0.05;
        perim *= 10;
        perim = (int)perim;
        perim = ((double)perim)/10;
        System.out.println("Area: "+area);
        System.out.println("Perimneter: "+perim);
    }
    public static void question3(){
        System.out.println(60*24*365);
    }
    public static void question4(){
        long speed = 300000000;
        System.out.println(speed*60*60*24*365 + " is the distance of a lightyear");
    }
    public static void question6(){
        System.out.println(10*12);
    }
    public static void question7(){
        System.out.println(roundTenth((98.0-32)*5/9));
    }
    public static void question8(double n){
        System.out.println(roundTenth(Math.pow(n, 2))+" is its square");
        System.out.println(roundTenth(Math.sqrt(n))+" is its square root");
    }
    public static void question9(int num){
        System.out.println("Amount Due: "+roundHundredth(num*0.27));
    }
    public static void question10(int l, int w){
        System.out.println((int)roundTenth(l*w)+" is its area");
        System.out.println((int)roundTenth(l+l+w+w)+" is its perimeter");
    }
    public static double question11(double m, double v){
        return roundHundredth((1.0/2.0)*m*Math.pow(v, 2));
    }
}
