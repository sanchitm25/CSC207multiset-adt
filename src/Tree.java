import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private final T root;
    private final List<Tree<T>> subtrees;

    public Tree(T root){
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public Tree(T root, List<Tree<T>> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public int length(){
        if (this.isEmpty()){
            return 0;
        } else {
            int count = 1;
            for (Tree<T> subtree : this.subtrees){
                count += subtree.length();
            }
            return count;
        }
    }

    public int count(T item){
        if (this.isEmpty()){
            return 0;
        } else {
            int count = 0;
            if (this.root.equals(item)){
                ++count;
            }
            for (Tree<T> subtree : this.subtrees){
                count += subtree.count(item);
            }
            return count;
        }
    }

    @Override
    public String toString(){
        return this.strIndented(0);
    }

    private String strIndented(int depth){
        if (this.isEmpty()){
            return "";
        } else {
            StringBuilder str = new StringBuilder();
            str.append("  ".repeat(Math.max(0, depth)));
            str.append(this.root).append("\n");
            for (Tree<T> subtree : this.subtrees){
                str.append(subtree.strIndented(depth + 1));
            }
            return str.toString();
        }
    }

    public double average(){
        if (this.isEmpty()){
            return 0;
        } else {
            double[] rtn = average_helper();
            return rtn[0] / rtn[1];
        }
    }

    private double[] average_helper(){
        if (this.isEmpty()){
            return new double[]{0, 0};
        } else {
            double total = (double) root;
            double size = 1;
            for (Tree<T> subtree : this.subtrees){
                double[] rtn = subtree.average_helper();
                total += rtn[0];
                size += rtn[1];
            }
            return new double[]{total, size};
        }
    }

    public boolean equals(Tree<T> obj){
        if (this.isEmpty() && obj.isEmpty()){
            return true;
        } else if (this.isEmpty() || obj.isEmpty()){
            return false;
        } else {
            if (!this.root.equals(obj.root)){
                return false;
            }

            if (this.subtrees.size() != obj.subtrees.size()){
                return false;
            }

            for (int i = 0; i < this.subtrees.size(); ++i){
                if (!this.subtrees.get(i).equals(obj.subtrees.get(i))){
                    return false;
                }
            }

            return true;
        }
    }

    public boolean contains(T item){
        if (this.isEmpty()){
            return false;
        }

        if (this.root.equals(item)){
            return true;
        }

        for (Tree<T> subtree : this.subtrees){
            if (subtree.contains(item)){
                return true;
            }
        }

        return false;
    }

    public ArrayList<T> leaves(){
        ArrayList<T> rtn = new ArrayList<T>();
        if (this.isEmpty()){
            return rtn;
        }

        if (this.subtrees.isEmpty()){
            rtn.add(this.root);
        } else {
            for (Tree<T> subtree : this.subtrees){
                rtn.addAll(subtree.leaves());
            }
        }

        return rtn;
    }
//
//    public boolean deleteItem(T item);
//
//    private void deleteRoot();
//
//    private T extractLeaf();
//
//    public void insert(T item);
//
//    public boolean insertChild(T item, T parent);
//

}
