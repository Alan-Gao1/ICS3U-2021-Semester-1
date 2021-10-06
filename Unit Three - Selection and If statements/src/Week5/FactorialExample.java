package Week5;

public class FactorialExample{
    public static void main(String[] args) {
        int result = factorial(7);
        System.out.println(result);
        System.out.print(fibbonaci(45));
    }
    private static int factorial(int n) {
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    private static int fibbonaci(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return fibbonaci(n-2)+fibbonaci(n-1);
        }
    }
}