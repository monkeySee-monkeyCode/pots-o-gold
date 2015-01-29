package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class Node {

    private int value;
    private Node left;
    private Node right;
    private Node parent;

    private int currentValue;
    private int opponentValue;

    private int winPercent;
    private int opponentWinPercent;

    public Node(int value) {
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getOpponentValue() {
        return opponentValue;
    }

    public void setOpponentValue(int opponentValue) {
        this.opponentValue = opponentValue;
    }

    public int getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(int winPercent) {
        this.winPercent = winPercent;
    }

    public int getOpponentWinPercent() {
        return opponentWinPercent;
    }

    public void setOpponentWinPercent(int opponentWinPercent) {
        this.opponentWinPercent = opponentWinPercent;
    }
}
