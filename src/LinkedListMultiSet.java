public class LinkedListMultiSet<T> extends MultiSet<T> {
    private Node<T> front;
    private int size;

    public LinkedListMultiSet(){
        this.front = null;
        this.size = 0;
    }

    @Override
    boolean add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = this.front;
        this.front = newNode;
        this.size++;
        return true;
    }

    @Override
    void remove(T item) {
        Node<T> cur = this.front;
        Node<T> prev = null;
        while (cur != null){
            if (cur.item.equals(item)){
                this.size -= 1;
                if (prev != null){
                    prev.next = cur.next;
                } else {
                    this.front = cur.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    boolean contains(T item) {
        Node<T> cur = this.front;
        while (cur != null){
            if (cur.item.equals(item)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    boolean is_empty() {
        return this.front == null;
    }

    @Override
    int count(T item) {
        int count = 0;
        Node<T> cur = this.front;
        while (cur != null){
            if (cur.item.equals(item)){
                count++;
            }
            cur = cur.next;
        }
        return count;
    }

    @Override
    int size() {
        return this.size;
    }
}

class Node<T> {
    public T item;
    public Node<T> next;

    public Node(T item){
        this.item = item;
        this.next = null;
    }
}