import java.util.Scanner;
public class InsertionSort {
    static void insertionSort(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            for(; j >= 0 && arr[j] > key; j--)
                arr[j + 1] = arr[j]; 
            arr[j + 1] = key;
            displayArray(arr);
        } 
    }
    static void displayArray(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        sc.close();
        insertionSort(n, arr);
        // displayArray(arr);
    }   
}
