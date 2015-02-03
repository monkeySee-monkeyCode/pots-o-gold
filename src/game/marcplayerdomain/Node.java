package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class Node<T> {

    private T metaData;
    private Node left;
    private Node right;
    private Node parent;

    public Node(T value) {
        this.metaData = value;
        this.left = null;
        this.right = null;
    }

    public boolean isRoot() {
        return false;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public T getMetaData() {
        return metaData;
    }

    public void setMetaData(T metaData) {
        this.metaData = metaData;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.setParent(this);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        right.parent = this;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
