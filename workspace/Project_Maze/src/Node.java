
public class Node {

	private Object val;
	private Node next;
	
	public Node (Object o , Node n)
	{
		this.val = o;
		this.next = n;
	}

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
