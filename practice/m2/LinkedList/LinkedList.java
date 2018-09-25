class LinkedList {
	private int size;
	private Node start;

	LinkedList() {
		this.start = null;
		this.size = 0;
	}
	public void pushRight(int data) {
		//Node start = new Node(data);
		if (start == null) {
			start = new Node(data);
		} else {

			Node temp = start;
			Node obj = new Node(data);
			while(temp.getNextnode()!=null) {
				temp = temp.getNextnode();
			}
			temp.setNextnode(obj);
		}
		size++;
	}
	public void pushLeft(int data) {
		Node newnode = new Node(data);
		newnode.setNextnode(start);
		start = newnode;
		size++;
	}
	public int size() {
		return size;
	}
	public void removeLeft() {
		if (start !=null) {
			start = start.getNextnode();
		}
		size--;
	}
	public void removeRight() {
		if (start == null) {
			System.out.println("There are no elements in the list");
		} else if (size < 2) {
			start = null;

		} else {
			Node temp = start;
			while(temp.getNextnode().getNextnode()!=null) {
				temp = temp.getNextnode();
			}
				temp.setNextnode(null);
		}
		size--;
	}
	public String toString() {
		String s = "";
		Node temp = start;
		if (temp == null) {
			return "Empty linked list";
		}
		while (temp.getNextnode() != null) {
			s += temp.getData() + ", ";
			temp = temp.getNextnode();
		} s += temp.getData();
		return s;
	}

}
