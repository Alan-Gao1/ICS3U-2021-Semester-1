package Week1;
/**
 * final modifier - used to set a variable that cannot be changed
 */
public class ExampleSix {
    public static void main(String[] args) {
        final int x = 7;
        //x = 8; Syntax error - we cannot assigna  value to a previously declared variable\

        final int y;
        y = x; //no issue because it is the first time we are assigning a value to y

        final int NUMBER_OF_STUDENTS =  30; //naming convention for constant is all caps and underscores for spaces

        
    }
}
