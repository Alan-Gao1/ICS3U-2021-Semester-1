package Week11;

public class SortingAlgorithims{
    public static void main(String[] args) {
        int[] arr = {30,20,5,70,90,85,10};
        //selectionSort(arr);
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int j;
            for(j=i; j>0&&temp<arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            int smallestIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[smallestIndex]){
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}