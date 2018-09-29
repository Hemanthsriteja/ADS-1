class LinkedList {
    private Node first;
    private Node last;
    private int size;
    class Node {
        private String number;
        private Node next;
    }
    LinkedList() {
        first = last;
        first = null;
        size = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void pop() {
        if (last != null) {
       Node temp = first;
       while(temp.next.next != null) {

            temp = temp.next;
        }
        temp.next = null;
        last = temp;
        size--;
    }
    }

public void push(String number) {
        if(last == null) {
            last = new Node();
            last.number = number;
            last.next = null;
            first = last;
        }   else {
            Node temp = last;
            last = new Node();
            last.number = number;
            last.next = null;
            temp.next = last;
        }
        size++;
    }
    public int getsize() {
        return size;
    }
    void print()
    {
        while (first != null)
        {
            System.out.print(first.number);
            first = first.next;
        }
    }
    public String displayAll() {
        if(size!=0) {
            String s = "";
            Node temp = first;
            while(temp!=null){
                s += temp.number;
                temp = temp.next;
            }
            return s;
        }
        return null;
    }
}

