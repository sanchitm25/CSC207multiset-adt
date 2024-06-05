abstract class MultiSet<T> {
    abstract boolean add(T item);

    abstract void remove(T item);

    abstract boolean contains(T item);

    abstract boolean is_empty();

    abstract int count(T item);

    abstract int size();
}
