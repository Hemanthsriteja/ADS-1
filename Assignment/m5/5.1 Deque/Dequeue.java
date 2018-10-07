class Deque {
    LinkedList deque;
    Deque() {
        deque = new LinkedList();
    }
    public void addFirst(int item) {
        deque.Insertfront(item);
    }
    public void addLast(int item) {
        deque.Insertback(item);
    }
    public void removeFirst() {
        deque.erasefront();
    }
    public boolean isempty() {
        return deque.isEmpty();
    }
    public void removeLast() {
        deque.eraseback();
    }
    public int size() {
        return deque.getsize();
    }
    public String display() {
        return deque.displayAll();
    }
}