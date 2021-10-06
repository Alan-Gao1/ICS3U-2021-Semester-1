package Week5;

public class DeMorgansLaw {
    public static void main(String[] args) {
        int x = 7;

        boolean result = (x<3)&&(x>10);

        System.out.println(result);

        boolean result2 = !((x<3)&&(x>10));
        
        System.out.println(result2);
    }
}
