/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
import java.util.Random;
import java.util.stream.IntStream;

public class interview2_1 {
	public static void main(String args[]) {
		Node head = init(10);
	 	printNode(head);
		System.out.println("nthToLast" + nthToLast(head, 3));
		Node ref = head;
		if (ref == null) return;
		while (ref != null && ref.next != null) {
			Node compare = ref;
			do {
				if (ref.data == compare.next.data) {
					deleteNode(compare);
					printNode(head);
				}
				else {
					compare = compare.next;
				}
			}
			while (compare.next != null);
			ref = ref.next;
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

	public static Node init(int size) {
		boolean hasHead = false;
		Node head = null;
		Random rnd = new Random();
		int[] rndData = rnd.ints(size, 1, size + 1).toArray();
		//int[] rndData = IntStream.range(1, size+1).toArray();
		Node node = null;
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

	public static Node nthToLast(Node head, int n) {
		
		if (head == null || n < 1) {
			return null;
		}
			
		Node p1 = head;
		Node p2 = head;
			
		for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
					
			p2 = p2.next;
		}
			
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}

