package game.julianplayerdomain;

/**
 * Created by Julian on 1/29/2015.
 */
public class Node {
    public Node left;
    public Node right;
    public Node parent;

    public int currentScore;
    public int totalWins = -1;

    public int id;
    public int leftPointer;
    public int rightPointer;


    public boolean isRoot(){
        return false;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isLeft(){if (this.parent.left == this){
        return true;
    } else {
        return false;
    }}


    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
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

    public void setCurrentScore(int currentScore){
        this.currentScore = currentScore;
    }

    public int getCurrentScore(){
        return currentScore;

    }

    public Node spawnChild(){
        if (this.hasLeft()){
            Node right = new Node();
            right.parent = this;
            right.rightPointer = this.rightPointer - 1;
            return right;
        } else{
            Node left = new Node();
            left.parent = this;
            left.leftPointer = this.leftPointer + 1;
            return left;
        }
    }
}


