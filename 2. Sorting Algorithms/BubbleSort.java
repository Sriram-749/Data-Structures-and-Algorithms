import java.util.Scanner;
public class BubbleSort {
    static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int flag = 0;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    flag = 1;
                    arr[j + 1] = arr[j] + arr[j + 1] - (arr[j] = arr[j + 1]);
                }
            }
            if(flag == 0)
                break;
        }
    }

    static void displayArray(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.print("Array before bubble sort: ");
        displayArray(arr);
        bubbleSort(arr);
        System.out.print("Array after bubble sort: ");
        displayArray(arr);
        sc.close();
    }
}
