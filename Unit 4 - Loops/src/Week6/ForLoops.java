package Week6;

public class ForLoops {
    public static void main(String[] args) {
        whileLoop();
        forLoop();
        forLoop2();
    }

    private static void forLoop() {
        int sum = 0;
        for(int i = 0; i<=100; i++){
            sum+=i;
        }
        System.out.println(sum);
    }

    private static void forLoop2() {
        int sum = 0;
        for(int i = 0; i<=100; i+=2){
            sum+=i;
        }
        System.out.println(sum);
    }

    private static void whileLoop() {
        int i = 0;
        int sum = 0;
        while(i<=100){
            sum+=i;
            i++;
        }
        System.out.println(sum);
    }
}
