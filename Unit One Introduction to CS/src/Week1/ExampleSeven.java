package Week1;
/**
 * compound assignment
 */
public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;

        //x = x + 7;   x is added
        x += 7;    //8
        x -= 3;    //5
        x *= 2;    //10
        x /= 3;    //3
        x %= 4;    //3

        x++;    //increase by 1
        x--;    //decrease by 1

        int y = 2*x++;
        int z = 2*++x;
    }
}
