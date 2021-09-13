package Week1;
/**
 * Type Casting (Primitives)
 */
public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;
        int m1 = 87;
        int m2 = 93;
        int m3 = 91;
        int m4 = 68;
        int m5 = 98;

        double average = (double)(m1+m2+m3+m4+m5)/NUM_MARKS;
        System.out.println(average);

        double z = 4.5;
        int y = (int) z;
    }
}
