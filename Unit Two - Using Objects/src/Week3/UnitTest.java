package Week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(twoChar("ahfueaaa", 3));
        System.out.println(removeChars("Happy", 0, 2));
        System.out.println(sqrtSum(2394));
    }
    /**
     * prints 3 copies of a substring in str starting at index
     * Example: twoChar("happy", 1) => apapap
     */
    public static String twoChar(String str, int index){
        String sub = str.substring(index, index+2);
        return sub+sub+sub;
    }
    public static String removeChars(String str, int index, int n){
        String str1 = str.substring(0,index);
        String str2 = str.substring(index+n);
        return str1+str2;
    }
    public static double sqrtSum(int number){
        int n1 = number/1000;
        int n2 = (number%1000)/100;
        int n3 = (number%100)/10;
        int n4 = number%10;
        return Math.sqrt((n1+n2+n3+n4));
    }
    
}
