
public class Queue {
	
	private static final Exception QueueEmptyException = null;
	private Node head;
	private Node tail;
	private int size;
	
	public Queue () {
		head = new Node(null,null);
		tail = head;
	}
	
	public void enqueue(Object item) throws Exception {
		tail.setNext(new Node(item,null));
		tail = tail.getNext();
		size++;
	}
	
	public Object front() throws Exception {
		if (isEmpty()) throw QueueEmptyException;
		Object val = head.getNext().getVal();
		return val;
	}
	
	public Object dequeue() throws Exception {
		if (isEmpty()) throw QueueEmptyException;
		Object val = head.getNext().getVal();
		head = head.getNext();
		size--;
		return val;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

}
