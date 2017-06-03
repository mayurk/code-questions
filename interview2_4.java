/*
You have two numbers represented by a linked list, where each node contains a sin-
gle digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
Output: 8 -> 0 -> 8
*/

import java.util.Random;

public class interview2_4 {
	public static void main(String[] args) {
		init(new int[] {3, 1, 5});
		init(new int[] {5, 1, 5});
	}

	public static void printNode(Node head) {
		do {
			System.out.print(head);
			head = head.next;
		}
		while(head != null);
		System.out.println("");
	}

	public static void deleteNode(Node node) {
		Node del = node.next;
		node.next = node.next.next;
		del.next = null;
	}

	public static Node init(int[] rndData) {
		boolean hasHead = false;
		Node head = null;
		Random rnd = new Random();
		//int[] rndData = rnd.ints(size, 1, size + 1).toArray();
		//int[] rndData = IntStream.range(1, size+1).toArray();
		Node node = null;
		int size = rndData.length;
		while (size > 0) {
			if (!hasHead) {
				node = new Node();
				node.head = node;
				head = node;
				hasHead = true;
			}
			else {
				node.head = null;
			}

			node.data = rndData[size -1];
			size--;

			if (size == 0) {
				node.next = null;
			}
			else {
				node.next = new Node();
				node = node.next;
			}
		}
		return head;
	}
}
