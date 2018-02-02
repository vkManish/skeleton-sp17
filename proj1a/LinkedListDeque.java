public class LinkedListDeque<T> {
	private Node<T> head;

	public LinkedListDeque() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(T item) {
		head = new Node<T>(item, head);
	}

	public void addLast(T item) {
		if (head == null) 
			addFirst(item);
		else {
			Node<T> temp = head;
			while (temp.next != null) 
				temp = temp.next;
			temp.next = new Node<T>(item, null);
		}
	}

	public int size() {
		Node<T> temp = head;
		int len = 0;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}

	public T get(int index) {
		if (head == null) throw new IndexOutOfBoundsException();

		Node<T> temp = head;
		for (int i =0 ;i< index; i++) 
			temp = temp.next;

		if (temp == null) throw new IndexOutOfBoundsException();

		return temp.data;
	}

	public T removeFirst() {
		T temp = get(0);
		head = head.next;
		return temp;
	}

	public T removeLast() {
		Node<T> tempNode = head;
		if (size() == 1) 
			return removeFirst();

		while (tempNode.next != null) {
			if (tempNode.next.next == null) {
				T temp = tempNode.next.data;
				tempNode.next = null;
				return temp;
			}
		}
		return null;
	}

	public void printDeque() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T dataIn, Node<T> nextIn){
		data = dataIn;
		next = nextIn;
	}
}