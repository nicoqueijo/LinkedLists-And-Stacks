package cop3530_assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * *******************************************************************
 * Purpose/Description: Converts an infix expression to a postfix expression.
 * Author’s Panther ID: 5152398 
 * Certification: I hereby certify that this work
 * is my own and none of it is the work of any other person.
 * ******************************************************************
 */
public class InfixToPostfixConverter {

    /**
     * Tests the functionality of the infixToPostfix method by allowing the user
     * to input an infix expression and then converting it to a postfix
     * expression.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        final String STOP = "=";
        Scanner scanner = new Scanner(System.in);
        List<Character> infixExpression = new ArrayList<>();
        char input;

        System.out.println("Enter each character of an infix expression or = to stop: ");
        System.out.println("Note: only operands a-z and operators + - * / ( ) allowed.");
        while (!scanner.hasNext(STOP)) {
            input = scanner.next().charAt(0);
            infixExpression.add(input);
        }

        System.out.println();

        List<Character> postfixExpression = infixToPostfix(infixExpression);

        System.out.print("Infix notation:   ");
        for (Character token : infixExpression) {
            System.out.print(token + " ");
        }
        System.out.println();
        System.out.print("Postfix notation: ");
        for (Character token : postfixExpression) {
            System.out.print(token + " ");
        }
        System.out.println();

    }

    /**
     * Converts an infix expression to postfix using a list and a stack to
     * manipulate each element and place them in the correct order.
     *
     * @param infixExpression the expression in infix notation.
     * @return the expression in postfix notation.
     */
    public static List<Character> infixToPostfix(List<Character> infixExpression) {

        List<Character> postfixExpression = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();
        int infixSize = infixExpression.size();

        for (int i = 0; i < infixSize; i++) {
            char currentToken = infixExpression.get(i);
            if (isOperator(currentToken)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' && hasHigherPrecedence(operatorStack.peek(), currentToken)) {
                    postfixExpression.add(operatorStack.pop());
                }
                operatorStack.push(currentToken);
            } else if (isOperand(currentToken)) {
                postfixExpression.add(currentToken);
            } else if (currentToken == '(') {
                operatorStack.push(currentToken);
            } else if (currentToken == ')') {
                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    postfixExpression.add(operatorStack.pop());
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.add(operatorStack.pop());
        }
        return postfixExpression;
    }

    /**
     * Checks the weight of an operator.
     *
     * @param operator the operator to be checked.
     * @return the weight of the operator.
     */
    public static int getOperatorWeight(char operator) {
        int weight = -1;
        switch (operator) {
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
        }
        return weight;
    }

    /**
     * Checks which of two operators has higher precedence.
     *
     * @param operator1 the first operator to be checked.
     * @param operator2 the second operator to be checked.
     * @return true if the first operator has higher or equal precedence than
     * the second. false otherwise.
     */
    public static boolean hasHigherPrecedence(char operator1, char operator2) {
        int operator1Weight = getOperatorWeight(operator1);
        int operator2Weight = getOperatorWeight(operator2);
        return (operator1Weight >= operator2Weight);
    }

    /**
     * Checks whether a token is an operator.
     *
     * @param token the character to be checked.
     * @return true if the token is an operator. false otherwise.
     */
    public static boolean isOperator(char token) {
        return (token == '+' || token == '-' || token == '*' || token == '/');
    }

    /**
     * Checks whether a token is an operand.
     *
     * @param token the character to be checked.
     * @return true if the token is an operand. false otherwise.
     */
    public static boolean isOperand(char token) {
        return (token >= 'a' && token <= 'z');
    }

}
