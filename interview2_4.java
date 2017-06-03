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
		Node node1 = init(new int[] {8, 9, 5, 3, 6, 8, 9});
		Node node2 = init(new int[] {5, 9, 5, 3, 4});
		Node head = node1;

		printNode(node1);
		printNode(node2);

		while (node1 != null || node2 != null) {
			int sum = ((node1 != null) ? node1.data : 0) + ((node2 != null) ? node2.data : 0);
			if (sum > 9) {
				sum = sum - 10;
				if (node1.next != null) {
					node1.next.data += 1;
				}
				else {
					node1.next = new Node();
					node1.next.data = 1;
				}
			}

			node1.data = sum;

			if (node1.next == null && node2 != null && node2.next != null) node1.next = new Node();
			node1 = node1.next;
			if (node2 != null) node2 = node2.next;
		}

		printNode(head);

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
