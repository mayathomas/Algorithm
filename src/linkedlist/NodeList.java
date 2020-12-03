package linkedlist;

public class NodeList {
	
	Node head;
	
	Node tail;
	
	public NodeList() {
	}
	
	public void insert(Node node) {
		if(this.head == null) {
			this.head = node;
			this.tail = node;
			this.head.next = tail;
			return;
		}
		tail.next = node;
		tail = node;
	}
	
	public void print() {
		Node node = head;
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

}
