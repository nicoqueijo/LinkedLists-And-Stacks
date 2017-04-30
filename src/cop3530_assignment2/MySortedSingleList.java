package cop3530_assignment2;

/**
 * *******************************************************************
 * Purpose/Description: Implements a sorted linked list with some basic
 * operations. 
 * Author’s Panther ID: 5152398 
 * Certification: I hereby certify that
 * this work is my own and none of it is the work of any other person.
 * ******************************************************************
 */
public class MySortedSingleList {

    private Node<Comparable> head = new Node<>();
    private int size = 0;

    private class Node<Comparable> {

        Comparable data;
        Node next;

        Node() {
            this(null, null);
        }

        Node(Comparable d) {
            this(d, null);
        }

        Node(Comparable d, Node n) {
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
     * adds a value x in the correct spot to maintain the list sorted if it is
     * not already contained in the list.
     *
     * @param x the value to be added.
     * @return the operation status.
     */
    public boolean add(Object x) {
        if (!contains(x)) {
            Comparable xComparable = (Comparable) x;
            Node tempNode = head;
            Node newNode = new Node();
            newNode.data = xComparable;
            if (tempNode.next == null) {
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                size++;
                return true;
            }
            while (tempNode.next != null) {
                if (xComparable.compareTo(tempNode.next.data) < 0) {
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    size++;
                    return true;
                }
                tempNode = tempNode.next;
            }
            newNode.next = null;
            tempNode.next = newNode;
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
     * Tests the functionality and operations of the MySortedSingleList class.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        MySortedSingleList sortedList = new MySortedSingleList();

        System.out.println("Adding 7 numbers to the list...");
        sortedList.add(6);
        sortedList.add(9);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(1);
        sortedList.add(8);
        sortedList.add(2);

        System.out.println();
        System.out.print("Printing elements in list: ");
        sortedList.print();
        System.out.println();
        System.out.print("Size of list: ");
        System.out.print(sortedList.size());
        System.out.println();
        System.out.println();
        System.out.println("Does the list contain the number 5? ");
        System.out.println(sortedList.contains(5));
        System.out.println("Does the list contain the number 7? ");
        System.out.println(sortedList.contains(7));
        System.out.println();
        System.out.println("Adding the number 3 to the list...");
        sortedList.add(3);
        System.out.print("Printing elements in list: ");
        sortedList.print();
        System.out.println();
        System.out.println("Removing the number 8 from the list...");
        sortedList.remove(8);
        System.out.print("Printing elements in list: ");
        sortedList.print();
        System.out.println();
        System.out.println();
        System.out.println("Attempting to add a duplicate number to the list (4)...");
        sortedList.add(4);
        System.out.print("Printing elements in list: ");
        sortedList.print();
        System.out.println();

    }

}
