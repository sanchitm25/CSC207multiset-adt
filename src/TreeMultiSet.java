public class TreeMultiSet<T> extends MultiSet<T>{
    private Tree<T> tree;

    public TreeMultiSet(){
        this.tree = new Tree<T>(null);
    }

    @Override
    public boolean add(T item){
        this.tree.insert(item);
        return true;
    }

    @Override
    void remove(T item) {
        this.tree.deleteItem(item);
    }

    @Override
    boolean contains(T item) {
        return this.tree.contains(item);
    }

    @Override
    boolean is_empty() {
        return this.tree.isEmpty();
    }

    @Override
    int count(T item) {
        return this.tree.count(item);
    }

    @Override
    int size() {
        return this.tree.length();
    }


}
