import java.util.Scanner;
public class LinearSearch {
    static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == target)
                return i + 1;
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter the target value to find: ");
        int target = sc.nextInt();
        int position = linearSearch(arr, target);
        if(position == -1)
            System.out.println("Target value not found in the array");
        else
            System.out.println("Target value found at position " + position);
        sc.close();
    }
}
