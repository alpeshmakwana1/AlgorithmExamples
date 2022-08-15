package searchingalgos;

/**
 * Works with Sorted array only
 * Time Complexity O(√N)
 * Space Complexity O(1)
 */
public class JumpSearch {

    /**
     * @param arr array in which element needs to be searchd
     * @param key value of search element
     * @return position of search element in array ,return -1 in case element in not present
     */
    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(arr.length));

        //Store previous block start position
        int prev = 0;

        // Finding the block where element is
        // present (if it is present)
        while (arr[Math.min(step, arr.length) - 1] < key) {
            System.out.println(arr[Math.min(step, arr.length) - 1] );
            prev = step;
            step += step;
            if (prev >= arr.length) {
                return -1;
            }
        }

        // Doing a linear search for key in block
        // beginning with prev.
        while (arr[prev] < key) {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, arr.length - 1)) {
                return -1;
            }
        }

        //element is found
        if (arr[prev] == key) {
            return prev;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 13, 24, 35, 47, 58, 69, 70, 81, 93};
        int key = 81;

        // Function call
        int position = search(arr, key);
        if (position == -1) {
            System.out.println(String.format("Search element %d is not present in array", key));
        } else {
            System.out.println(String.format("Search element %d is present at index %d", key, position));
        }

    }

}
