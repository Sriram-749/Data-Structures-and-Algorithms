import java.util.Scanner;
public class BinarySearch {
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target)
                return mid + 1;
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
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
        int position = binarySearch(arr, target);
        if(position == -1)
            System.out.println("Target value not found in the array");
        else
            System.out.println("Target value found at position " + position);
        sc.close();
    }
}
