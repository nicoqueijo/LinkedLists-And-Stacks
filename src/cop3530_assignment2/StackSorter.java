package cop3530_assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * *******************************************************************
 * Purpose/Description: Sorts a stack with the help of an auxiliary stack.
 * Author’s Panther ID: 5152398 
 * Certification: I hereby certify that this work
 * is my own and none of it is the work of any other person.
 * ******************************************************************
 */
public class StackSorter {

    /**
     * Tests the functionality of the stackSorter method by creating a random
     * list of 20 integers between numbers 1-20 and then sorting it.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        List<Integer> randomList = randomArrayList(20);
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.addAll(randomList);

        System.out.println("Unsorted stack: ");
        System.out.println(unsortedStack);

        Stack<Integer> sortedStack = stackSorter(unsortedStack);
        System.out.println("Sorted stack: ");
        System.out.println(sortedStack);

    }

    /**
     * Sorts a stack using an auxiliary stack and an integer placeholder
     * variable.
     *
     * @param unsortedStack a list in the form of a stack to be sorted.
     * @return the sorted stack.
     */
    public static Stack<Integer> stackSorter(Stack<Integer> unsortedStack) {
        int currentElement;
        Stack<Integer> auxiliaryStack = new Stack<>();
        while (!unsortedStack.isEmpty()) {
            currentElement = unsortedStack.pop();
            if (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() <= currentElement) {
                auxiliaryStack.push(currentElement);
            } else {
                while (!auxiliaryStack.isEmpty() && currentElement < auxiliaryStack.peek()) {
                    unsortedStack.push(auxiliaryStack.pop());
                }
                auxiliaryStack.push(currentElement);
            }
        }
        return auxiliaryStack;
    }

    /**
     * Generates an list of random elements between integer values 1-20.
     *
     * @param numberOfElements the size of the random list to be generated.
     * @return the randomised list.
     */
    public static List<Integer> randomArrayList(int numberOfElements) {
        List<Integer> randomIntegerList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            randomIntegerList.add(random.nextInt(20) + 1);
        }
        return randomIntegerList;
    }

}

/**
 * *****************************************************************************
 * PART B
 *
 * Running time complexity of this algorithm is O(n^2) also known as quadratic.
 * This is because on an already sorted stack it is very similar in nature to
 * the insertion sort.
 *
 *******************************************************************************
 */
