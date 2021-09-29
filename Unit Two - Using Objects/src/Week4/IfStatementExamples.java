package Week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo(77);
        exampleThree();
    }
    private static void exampleThree() {
        //OR = || (if either is true, the entire thing is true)
        //AND = && (if either is false, the entire thing is false; everything must be true for the statement to be true)
        /**
         * >
         * <
         * ==
         * <=
         * >=
         * ==
         * != (not equals)
         * !(x>7) IS BASICALLY x is NOT bigger than 7 OR x is LESS THAN OR EQUAL TO 7
         */
    }
    private static void exampleTwo(int mark){
        if (mark >= 90){
            System.out.print("A+");
        }else if(mark>=80){
            System.out.println("A");
        }else if(mark>=70){
            System.out.println("B");
        }else if(mark>=60){
            System.out.println("C");
        }else if(mark>=50){
            System.out.print("D");
        }else{
            System.out.println("F");
        }
        // b 70, c 60, d 50
    }
    private static void exampleOne() {
        /**
         * if (boolean expression is true){
                //do this
           }
         */
        int x = 7;
        if (x%2==0){
            System.out.println(x+" is even");
        }else{
            System.out.println(x+" is odd");
        }
    }
}
