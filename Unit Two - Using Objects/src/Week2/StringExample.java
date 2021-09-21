package Week2;

public class StringExample {
    public static void main(String[] args) {
        String stringLiteral = "This is a String literal";
        String anotherliteral = "This is a String literal";
        String somethingdifferent = new String("This is a String literal");//I am lying
        String somethingdifferent1 = new String("This is a String literal");
        String something_different2 = new String("This is a String literal");

        System.out.println(stringLiteral.length());
        System.out.println(stringLiteral.equals(somethingdifferent));

        System.out.println(stringLiteral.indexOf("in"));
        System.out.println(stringLiteral.indexOf("happy")); //returns -1 if it doesnt exist in the string
        System.out.println(stringLiteral.substring(3));
        System.out.println(stringLiteral.substring(3, 6));
        /**
         * substring gets a substring including the first index but not including the last index
         */
    }
}
