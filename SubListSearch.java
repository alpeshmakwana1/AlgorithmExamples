package searchingalgos;// Java program to find a list in second list
/**
 * Works with Sorted array only
 * Time Complexity O(list1 size * list2 size)
 */
class SubListSearch {

    // A Linked List node
    static class Node {
        int data;
        Node next;
    }

    ;

    // Returns true if first list is
// present in second list
    static boolean findList(Node list1,
                            Node list2) {
        Node ptr1 = list1, ptr2 = list2;

        // If both linked lists are empty,
        // return true
        if (list1 == null && list2 == null)
            return true;

        // Else If one is empty and
        // other is not, return false
        if ((list1 == null && list2 != null) ||
                (list1 != null && list2 == null))
            return false;

        // Traverse the second list by
        // picking nodes one by one
        while (list2 != null) {
            // Initialize ptr2 with
            // current node of second
            ptr2 = list2;

            // Start matching first list
            // with second list
            while (ptr1 != null) {
                // If second list becomes empty and
                // first not then return false
                if (ptr2 == null)
                    return false;

                    // If data part is same, go to next
                    // of both lists
                else if (ptr1.data == ptr2.data) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }

                // If not equal then break the loop
                else break;
            }

            // Return true if first list gets traversed
            // completely that means it is matched.
            if (ptr1 == null)
                return true;

            // Initialize ptr1 with first again
            ptr1 = list1;

            // And go to next node of second list
            list2 = list2.next;
        }
        return false;
    }

    // Function to add new node to linked lists
    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    // Driver Code
    public static void main(String[] args) {
	/* Let us create two linked lists to test
	the above functions. Created lists shall be
		a: 1->2->3->4
		b: 1->2->1->2->3->4*/
        Node list1 = newNode(1);
        list1.next = newNode(2);
        list1.next.next = newNode(3);
        list1.next.next.next = newNode(4);

        Node list2 = newNode(1);
        list2.next = newNode(2);
        list2.next.next = newNode(1);
        list2.next.next.next = newNode(2);
        list2.next.next.next.next = newNode(3);
        list2.next.next.next.next.next = newNode(4);

        if (findList(list1, list2) == true)
            System.out.println("LIST FOUND");
        else
            System.out.println("LIST NOT FOUND");
    }
}

// This code is contributed by Princi Singh
