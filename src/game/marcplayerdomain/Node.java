package game.marcplayerdomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marc.vis
 */
public class Node {

    private int value;
    private Node left;
    private Node right;
    private Node parent;

    private int currentScore = 0;
    private int opponentScore = 0;

    private int winPercent = 0;
    private int opponentWinPercent = 0;

    private int totalPositiveOutcomes = 0;
    private int totalNegativeOutcomes = 0;

    private int leftPositiveOutcomes = 0;
    private int leftNegativeOutcomes = 0;
    private int rightPositiveOutcomes = 0;
    private int rightNegativeOutcomes = 0;

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

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
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

    public int getLeftPositiveOutcomes() {
        return leftPositiveOutcomes;
    }

    public void setLeftPositiveOutcomes(int leftPositiveOutcomes) {
        this.leftPositiveOutcomes = leftPositiveOutcomes;
    }

    public int getRightPositiveOutcomes() {
        return rightPositiveOutcomes;
    }

    public void setRightPositiveOutcomes(int rightPositiveOutcomes) {
        this.rightPositiveOutcomes = rightPositiveOutcomes;
    }

    public int getLeftNegativeOutcomes() {
        return leftNegativeOutcomes;
    }

    public void setLeftNegativeOutcomes(int leftNegativeOutcomes) {
        this.leftNegativeOutcomes = leftNegativeOutcomes;
    }

    public int getRightNegativeOutcomes() {
        return rightNegativeOutcomes;
    }

    public void setRightNegativeOutcomes(int rightNegativeOutcomes) {
        this.rightNegativeOutcomes = rightNegativeOutcomes;
    }

    public int getTotalPositiveOutcomes() {
        return totalPositiveOutcomes;
    }

    public void setTotalPositiveOutcomes(int totalPositiveOutcomes) {
        this.totalPositiveOutcomes = totalPositiveOutcomes;
    }

    public int getTotalNegativeOutcomes() {
        return totalNegativeOutcomes;
    }

    public void setTotalNegativeOutcomes(int totalNegativeOutcomes) {
        this.totalNegativeOutcomes = totalNegativeOutcomes;
    }
}
