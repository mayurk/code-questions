public class Stack {
	private StackNode top = null;

	public static init(int size) {
		while (size > 0) {
			StackNode node = new StackNode();
			this.push(node);
			size--;
		}
	}

	public 

	public void push(StackNode node) {
		if (top == null) {
			top = node;
			node.prev = null;
			return;
		}
		
		node.prev = top;
		top = node;
		return;
	}

}
