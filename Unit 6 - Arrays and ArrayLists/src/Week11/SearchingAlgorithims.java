package Week11;

import java.util.Arrays;

public class SearchingAlgorithims {
    public static void main(String[] args) {
        int[] arr = {20,20,5,70,90,85,10};
        int index = linearSearch(arr,90);
        index = linearSearch(arr,92);

        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()*1000);
        }

        Arrays.sort(nums);



        Arrays.sort(arr);
        index = binarySearch(arr, 70);
        index = binarySearch(nums, 412);
    }

    private static int binarySearch(int[] arr, int findme) {
        int lower = 0;
        int upper = arr.length-1;
        while(upper>lower){
            int mid = upper+lower/2;
            if(arr[mid] == findme){
                return mid;
            }else if(arr[mid]>findme){
                upper = mid-1;
            }else{
                lower = mid+1;
            }
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int findMe) {
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == findMe){
                return i;
            }
        }
        return -1;
    }




}
