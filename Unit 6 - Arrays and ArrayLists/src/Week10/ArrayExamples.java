package Week10;

public class ArrayExamples {
    public static void main(String[] args) {
       accessArray();
       iterateArray();
    }

    private static void iterateArray() {
        int[] arr = {5,2,3,5,2};

        int sum = 0;

        for(int i = 0; i<arr.length;i++){
            sum+=arr[i];
        }

        System.out.println(sum);
    }

    private static void accessArray() {
       int[] arr = new int[5];
       Animal[] animals = new Animal[3];

       arr[0] = 3;
       arr[1] = 7;
       arr[2] = 10;
       arr[3] = 12;
       arr[4] = -2;

       System.out.println(arr.length);
       System.out.println(animals.length);
    }
}
