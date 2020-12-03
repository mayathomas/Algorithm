package linkedlist;

public class Main {

	public static void main(String[] args) {
		NodeList nodeList = new NodeList();
		nodeList.insert(new Node("1"));
		nodeList.insert(new Node("2"));
		nodeList.insert(new Node("3"));
		nodeList.insert(new Node("4"));
		nodeList.insert(new Node("5"));
		nodeList.print();
	}
}
