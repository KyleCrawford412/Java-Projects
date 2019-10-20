
public class NodeClass {
	
	private InfoClass info;
	private NodeClass next;
	private NodeClass prev;

	public NodeClass(InfoClass nodeInfo, NodeClass prevNode, NodeClass nextNode) {
		info = nodeInfo;
		prev = prevNode;
		next = nextNode;
	}

	public InfoClass getInfo() {
		return info;
	}

	public void setInfo(InfoClass newInfo) {
		info = newInfo;
	}
	
	public NodeClass getPrev() {
		return prev;
	}
	
	public void setPrev(NodeClass prevNode) {
		prev = prevNode;
	}

	public NodeClass getNext() {
		return next;
	}

	public void setNext(NodeClass nextNode) {
		next = nextNode;
	}

}
