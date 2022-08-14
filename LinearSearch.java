package searchingalgos;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
class LinearSearch {


    /**
     * @param arr array in which element needs to be searched
     * @param search_Element key which needs to be searched
     * @return method will return position of key element if it found in array otherwise return -1
     */
    public static int search(int arr[], int search_Element) {

        int n = arr.length;
        //Loop from first element to last element of array
        for (int i = 0; i < n; i++) {
            //If search element is found then return the position
            if (arr[i] == search_Element)
                return i;
        }
        return -1;
    }


    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int search_element = 5;

        // Function call
        int position = search(arr, search_element);

    }
}

