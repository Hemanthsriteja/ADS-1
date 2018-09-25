class Node {
	private int data;
	private Node nextNode;

	Node(int data) {
		this.data = data;
		this.nextNode = null;
	}
	public void setData(int  data) {
		this.data = data;
	}
	public void setNextnode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public int getData() {
		return this.data;
	}
	public Node getNextnode() {
		return this.nextNode;
	}
}
// public class Temp {
// 	public static void main(String[] args) {
// 		Node start = new Node("hi");
// 		//start.setName("saad");
// 		System.out.println(start.setName());

// 	}

// }