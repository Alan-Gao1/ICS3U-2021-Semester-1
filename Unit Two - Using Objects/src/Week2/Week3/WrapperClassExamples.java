package Week2.Week3;


public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.5);
        Integer num = 7; //auto-boxing
        int m = num; //auto-unboxing
        int x = 6+num; //auto-unboxing so we can add a primitive and obejct wrapper together
        int y = m+num; 
        int z = num.intValue(); //same as int z = num;
        double f = d.doubleValue();
    }
}
