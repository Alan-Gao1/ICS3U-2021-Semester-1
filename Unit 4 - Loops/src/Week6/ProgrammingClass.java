package Week6;

public class ProgrammingClass {
    public static void main(String[] args) {
        framingSquares(3, 4, 1, 2);
        diamonds("CANADA");
        wordFrame("BAYVIEWGLEN");
    }
    private static void framingSquares(int m, int n, int p, int q) {
        //TOP PART OF THE FRAME
        for(int i = 0; i < q; i++){
            for(int j = 0; j < n+(2*p)+(2*q); j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i = 0; i < p; i++){
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            for(int j = 0; j<2*p+n; j++){
                System.out.print("+");
            }
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            for(int j = 0; j<p; j++){
                System.out.print("+");
            }
            for(int j = 0; j<n; j++){
                System.out.print(".");
            }
            for(int j = 0; j<p; j++){
                System.out.print("+");
            }
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i = 0; i < p; i++){
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            for(int j = 0; j<2*p+n; j++){
                System.out.print("+");
            }
            for(int j = 0; j<q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i = 0; i < q; i++){
            for(int j = 0; j < n+(2*p)+(2*q); j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
    private static void diamonds(String str) {
        for(int i = 0; i<str.length()-1; i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0,1));
        for(int i = 1; i<str.length(); i++){
            String letter = str.substring(i, i+1);
            for(int j  = 0; j<str.length()-i-1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            for(int j  = 0; j < 2*i-1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            System.out.println();
        }
        for(int i = str.length()-2; i>0; i--){
            for(int j = 0; j<str.length()-i-1; j++){
                System.out.print(" ");
            }
            System.out.print(str.substring(i, i+1));
            for(int j = 0; j<2*i-1;j++){
                System.out.print(" ");
            }
            System.out.print(str.substring(i, i+1));
            System.out.println();
        }
        for(int i = 0; i<str.length()-1; i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0,1));
    }  
    private static void wordFrame(String str) {
        System.out.print("*");
        System.out.print(str);
        System.out.print("*");
        System.out.println();
        for(int i = 1; i<=str.length(); i++){
            for(int j = 0; j<1; j++){
                System.out.print(str.substring(str.length()-i, str.length()-i+1));
            }
            for(int j = 0; j<str.length(); j++){
                System.out.print("*");
            }
            for(int j = 0; j<1; j++){
                System.out.print(str.substring(i-1, i));
            }
            System.out.println();
        }
        System.out.print("*");
        for(int i = 1; i<=str.length(); i++){
            System.out.print(str.substring(str.length()-i, str.length()-i+1));
        }
        System.out.print("*");
    }
}
