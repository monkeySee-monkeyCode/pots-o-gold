package game.marcplayerdomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marc.vis
 */
public class Node {

    private int value = 0;
    private Node left;
    private Node right;

    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    private int firstPlayerPositiveOutcomes = 0;
    private int firstPlayerNegativeOutcomes = 0;
    private int secondPlayerPositiveOutcomes = 0;
    private int secondPlayerNegativeOutcomes = 0;

    public Node() {}

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
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getFirstPlayerScore() {
        return firstPlayerScore;
    }

    public void setFirstPlayerScore(int firstPlayerScore) {
        this.firstPlayerScore = firstPlayerScore;
    }

    public int getSecondPlayerScore() {
        return secondPlayerScore;
    }

    public void setSecondPlayerScore(int secondPlayerScore) {
        this.secondPlayerScore = secondPlayerScore;
    }

    public int getFirstPlayerPositiveOutcomes() {
        return firstPlayerPositiveOutcomes;
    }

    public void setFirstPlayerPositiveOutcomes(int firstPlayerPositiveOutcomes) {
        this.firstPlayerPositiveOutcomes = firstPlayerPositiveOutcomes;
    }

    public int getFirstPlayerNegativeOutcomes() {
        return firstPlayerNegativeOutcomes;
    }

    public void setFirstPlayerNegativeOutcomes(int firstPlayerNegativeOutcomes) {
        this.firstPlayerNegativeOutcomes = firstPlayerNegativeOutcomes;
    }

    public int getSecondPlayerPositiveOutcomes() {
        return secondPlayerPositiveOutcomes;
    }

    public void setSecondPlayerPositiveOutcomes(int secondPlayerPositiveOutcomes) {
        this.secondPlayerPositiveOutcomes = secondPlayerPositiveOutcomes;
    }

    public int getSecondPlayerNegativeOutcomes() {
        return secondPlayerNegativeOutcomes;
    }

    public void setSecondPlayerNegativeOutcomes(int secondPlayerNegativeOutcomes) {
        this.secondPlayerNegativeOutcomes = secondPlayerNegativeOutcomes;
    }
}
