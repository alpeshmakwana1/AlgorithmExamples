package searchingalgos;

/**
 * Works with Sorted array only
 * Time Complexity O(LogN)
 * Space Complexity O(LogN)
 */
public class BinarySearchIRecursive {

    /**
     * @param arr array in which element needs to be searchd
     * @param key value of search element
     * @return position of search element in array ,return -1 in case element in not present
     */
    public static int search(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            //Key is equal to value of mid element return mid position
            if (key == arr[mid]) {
                return mid;
                //If key less than value of mid element then search in left half of array
            } else if (key < arr[mid]) {
                high = mid - 1;
                return search(arr, low, high, key);
                //If key greater than value of mid element then search in right half of array
            } else if (key > arr[mid]) {
                low = mid + 1;
                return search(arr, low, high, key);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 13, 24, 35, 47, 58, 69, 70, 81, 93};
        int key = 35;

        if (arr == null || arr.length == 0) {
            System.out.println("Null or empty array");
            return;
        }

        // Function call
        int position = search(arr, 0, arr.length-1, key);
        if (position == -1) {
            System.out.println(String.format("Search element %d is not present in array", key));
        } else {
            System.out.println(String.format("Search element %d is present at index %d", key, position));
        }

    }

}
