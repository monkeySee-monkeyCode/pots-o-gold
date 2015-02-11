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

    public void convertToRoot(){
        this.isRoot = true;
        this.parent = null;
        this.currentScore = 0;
    }





    public Node spawnLeft(int[] rawBoard){
        Node node = new Node();
        node.parent = this;
        node.currentScore = this.currentScore + rawBoard[this.leftPointer];
        node.leftPointer = this.leftPointer++;

        return node;

    }

    public Node spawnRight(int[] rawBoard){
        Node node = new Node();
        node.parent = this;
        node.currentScore = this.currentScore + rawBoard[this.rightPointer];
        node.rightPointer = this.rightPointer--;
        return node;
    }



    public boolean isLeft() {
        return this.parent.left == this;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}














