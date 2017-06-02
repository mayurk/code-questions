import java.util.Random;

public class interview2_1 {
	public static void main(String args[]) {
		Node head = init(10);
		printNode(head);
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
		int[] rndData = rnd.ints(size, 1, size-2).toArray();
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
}

class Node {
	public int data;
	public Node head;
	public Node next;
	public Node tail;

	public String toString() {
		return "[" + this.data + "]->";
	}


}
