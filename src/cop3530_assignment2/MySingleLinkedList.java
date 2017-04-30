package cop3530_assignment2;

/**
 * *******************************************************************
 * Purpose/Description: Implements a linked list with some basic operations.
 * Author’s Panther ID: 5152398 
 * Certification: I hereby certify that this work
 * is my own and none of it is the work of any other person.
 * ******************************************************************
 */
public class MySingleLinkedList {

    private Node<Object> head = new Node();
    private int size = 0;

    private class Node<Object> {

        Object data;
        Node next;

        Node() {
            this(null, null);
        }

        Node(Object d) {
            this(d, null);
        }

        Node(Object d, Node n) {
            data = d;
            next = n;
        }

    }

    /**
     * Returns the list size.
     *
     * @return size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the list contains a certain value.
     *
     * @param x the value to be checked.
     * @return whether or not the list contains value x.
     */
    public boolean contains(Object x) {
        Node tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next.data.equals(x)) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    /**
     * adds a value x if it is not already contained in the list.
     *
     * @param x the value to be added.
     * @return the operation status.
     */
    public boolean add(Object x) {
        if (!contains(x)) {
            Node newNode = new Node();
            newNode.next = head.next;
            newNode.data = x;
            head.next = newNode;
            size++;
            return true;
        }
        return false;
    }

    /**
     * removes a value x if it is contained in the linked list.
     *
     * @param x the value to be removed.
     * @return the operation status.
     */
    public boolean remove(Object x) {
        if (contains(x)) {
            Node tempNode = head;
            while (tempNode.next != null) {
                if (tempNode.next.data.equals(x)) {
                    tempNode.next = tempNode.next.next;
                    size--;
                    return true;
                }
                tempNode = tempNode.next;
            }
            return true;
        }
        return false;
    }

    /**
     * prints the list.
     */
    public void print() {
        Node tempNode = head;
        while (tempNode.next != null) {
            System.out.print(tempNode.next.data + " ");
            tempNode = tempNode.next;
        }
    }

    /**
     * Tests the functionality and operations of the MySingleLinkedList class.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        MySingleLinkedList singleList = new MySingleLinkedList();

        System.out.println("Adding 9 numbers to the list...");
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.add(5);
        singleList.add(6);
        singleList.add(7);
        singleList.add(8);
        singleList.add(9);

        System.out.println();
        System.out.print("Printing elements in list: ");
        singleList.print();
        System.out.println();
        System.out.print("Size of list: ");
        System.out.print(singleList.size());
        System.out.println();
        System.out.println();
        System.out.println("Does the list contain the number 5? ");
        System.out.println(singleList.contains(5));
        System.out.println("Does the list contain the number 10? ");
        System.out.println(singleList.contains(10));
        System.out.println();
        System.out.println("Adding the number 13 to the list...");
        singleList.add(13);
        System.out.print("Printing elements in list: ");
        singleList.print();
        System.out.println();
        System.out.println("Removing the number 8 from the list...");
        singleList.remove(8);
        System.out.print("Printing elements in list: ");
        singleList.print();
        System.out.println();
        System.out.println();
        System.out.println("Attempting to add a duplicate number to the list (3)...");
        singleList.add(3);
        System.out.print("Printing elements in list: ");
        singleList.print();
        System.out.println();
    }

}
