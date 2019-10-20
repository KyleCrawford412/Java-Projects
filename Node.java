public class Node {
	
	private Info info;
	private Node next;
	private Node prev;

	public Node(Info nodeInfo, Node prevNode, Node nextNode) {
		info = nodeInfo;
		prev = prevNode;
		next = nextNode;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info newInfo) {
		info = newInfo;
	}
	
	public Node getPrev() {
		return prev;
	}
	
	public void setPrev(Node prevNode) {
		prev = prevNode;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node nextNode) {
		next = nextNode;
	}

}