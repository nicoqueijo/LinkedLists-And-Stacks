# Solves a few problems implementing linked list and stack data structures.

Problem #1:

The following Java implementation of a class Node is given:

	private class Node<Object> {
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
			Object data;
			Node next;
		}
		
Assume that a singly linked list is implemented with a header node, but no tail node, and
that it maintains only a reference to the header node.
Using the class Node described above, write a MySingleLinkedList class in Java includes
methods to:

	(a) int size() - return the size of the linked list.
	(b) void print() - print the linked list.
	(c) boolean contains(Object x) - test if a value x is contained in the linked list.
	(d) boolean add(Object x) - add a value x if it is not already contained in the linked list.
	(e) boolean remove(Object x) - remove a value x if it is contained in the linked list.

Problem #2:

The following Java implementation of a class Node is given:
	private class Node<Comparable> {
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
	Comparable data;
	Node next;
	}
	
Assume that a singly linked list is implemented with a header node, but no tail node, and
that it maintains only a reference to the header node.
Using the class Node described above, write a MySortedSingleList class in Java includes
methods to:

(a) boolean contains( Object x ) - test if a value x is contained in the linked list.
(b) boolean add( Object x ) - add a value x if it is not already contained in the linked list.
(c) boolean remove(Object x) - remove a value x if it is contained in the linked list.
maintaining the singly linked list in sorted order.

Problem #3

Implement a program in Java to convert an infix expression that includes (, ), +, -, *,
and / to postfix expression.
For simplicity, your program will read from standard input (until the user enters the symbol
“=”) an infix expression of single lower case and the operators +, -, /, *, and ( ), and
output a postfix expression.

Problem #4

(a) Implement a program in Java to sort a stack of integer in ascending order using for
this purpose another auxiliary (temp) stack.
You should not make any assumptions about how the stack is implemented. The
following are the only functions that should be used to write this program: push,
pop, peek, and isEmpty.
peek - operation that returns the value of the top element of the stack without
removing it.

(b) What is the running time complexity of your program?