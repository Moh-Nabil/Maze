public class Stack {
	
	private static final Exception StackEmptyException = null;
	private Node head;
	private int size;
	
	public Stack ()
	{
		head = new Node(null,null);
	}
	
	public void push (Object o)
	{
		Node n = new Node(o,head);
		head = n;
		size++;
	}

	public Object pop() throws Exception {
		if (isEmpty()) throw StackEmptyException;
		Object element = head.getVal();
		head= head.getNext();
		size--;
		return element;
	}

	public Object peek() throws Exception {
		if (isEmpty()) throw StackEmptyException;
		Object element = head.getVal();
		return element;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return this.size;
	}
	
}
