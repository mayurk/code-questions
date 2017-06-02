public class interview2_1 {
	public static void main(String args[]) {
		Node ref = head;
		while (ref.next != null) {
			do {
				Node compare = ref.next;
				if (ref.data == compare.data) {
					deleteNode(ref);
					last;
				}
				compare = compare.next;
			}
			while (compare != null);
			ref = ref.next;
		}
	}
}

class Node {
	
}
