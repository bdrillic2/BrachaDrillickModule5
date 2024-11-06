package doubleLinkedListWithIterator;

public class DNode <T extends Comparable<T>>{
	private T data;
	private DNode<T> next;
	private DNode<T> previous;
	
	public DNode(T data) {
		this.data = data;
		this .next =null;
		this.previous = null;
	}
	
	public void setNext(DNode<T> next) {
		this.next = next;
	}

	public DNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<T> previous) {
		this.previous = previous;
	}

	public T getData() {
		return data;
	}

	public DNode<T> getNext() {
		return next;
	}

}
