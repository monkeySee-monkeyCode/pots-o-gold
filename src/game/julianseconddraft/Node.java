package game.julianseconddraft;

/**
 * Created by Joe on 2/1/2015.
 */
public class Node {

    public int currentScore;
    public Node parent;
    public Node left;
    public Node right;
    public int leftPointer;
    public int rightPointer;
    public int totalWins = -1;
    public boolean isRoot = false;

    public Node spawnRoot(){
        this.isRoot = true;
        this.parent = null;
        this.currentScore = 0;

    }





    public Node spawnChild(int[] rawBoard){
        Node node = new Node();
        node.parent = this;
        if (node.isLeft){
            node.currentScore = this.currentScore + rawBoard[this.leftPointer];
            node.leftPointer = this.leftPointer++;
        } else {
            node.currentScore = this.currentScore + rawBoard[this.rightPointer];
            node.rightPointer = this.rightPointer--;
        }

    }



    public boolean isLeft() {
        if (this.parent.left == this) {
            return true;
        } else return false;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}














