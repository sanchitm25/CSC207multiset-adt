import java.util.ArrayList;

public class ArrayListMultiSet<T> extends MultiSet<T>{
    private ArrayList<T> list;

    public ArrayListMultiSet(){
        this.list = new ArrayList<>();
    }

    @Override
    boolean add(T item) {
        this.list.add(item);
        return true;
    }

    @Override
    void remove(T item) {
        this.list.remove(item);
    }

    @Override
    boolean contains(T item) {
        return this.list.contains(item);
    }

    @Override
    boolean is_empty() {
        return this.list.isEmpty();
    }

    @Override
    int count(T item) {
        int count = 0;
        for (T i : this.list){
            if (i.equals(item)){
                count++;
            }
        }
        return count;
    }

    @Override
    int size() {
        return this.list.size();
    }
}
