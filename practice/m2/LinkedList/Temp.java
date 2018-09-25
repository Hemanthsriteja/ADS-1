class Node {
	private String data;
	private Node nextNode;

	Node(String data) {
		this.data = data;
		this.nextNode = null;
	}
	public void setData(String  data) {
		this.data = data;
	}
	public void setNextnode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public String setName() {
		return this.data;
	}
	public Node getNextnode() {
		return this.nextNode;
	}
}
public class Temp {
	public static void main(String[] args) {
		Node start = new Node("hi");
		//start.setName("saad");
		System.out.println(start.setName());

	}

}