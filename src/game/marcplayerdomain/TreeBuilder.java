package game.marcplayerdomain;

import game.Board;

import java.util.List;

/**
 * @author marc.vis
 */
public class TreeBuilder {

    public static Node buildTree(Board board) {

        int[] rawBoard = board.getBoardRaw();

        Node root = new RootNode();
        traceBoard(root, rawBoard, 0, rawBoard.length - 1);
        calculateValues(root, 0, 0);
        calculateWinPercents(root);

        return root;
    }

    public static void traceBoard(Node node, int[] board, int leftMost, int rightMost) {
        if (leftMost <= rightMost) {
            Node leftChild = new Node(board[leftMost]);
            node.setLeft(leftChild);

            traceBoard(leftChild, board, leftMost + 1, rightMost);

            if (rightMost > leftMost) {
                Node rightChild = new Node(board[rightMost]);
                node.setRight(rightChild);

                traceBoard(rightChild, board, leftMost, rightMost - 1);
            }
        }
    }

    private static void calculateValues(Node node, int currentValue,
                                      int opponentCurrentValue) {
        if (node.isLeaf()) {
            node.setCurrentValue(currentValue);
            node.setOpponentValue(opponentCurrentValue);
        } else {
            if (node.hasLeft()) {
                calculateValues(node.getLeft(), opponentCurrentValue, currentValue + node.getValue());
            }
            if (node.hasRight()) {
                calculateValues(node.getRight(), opponentCurrentValue, currentValue + node.getValue());
            }
        }
    }

    private static void calculateWinPercents(Node node) {
        Node leftChild = null;
        Node rightChild = null;

        int leftPercentToWin = 0;
        int leftOppenentPercentToWin = 0;
        int rightPercentToWin = 0;
        int rightOpponentPercentToWin = 0;

        if (node.isLeaf()) {
            if (node.getParent() != null) {
                node.setWinPercent(node.getValue() >= node.getParent().getValue() ? 100 : 0);
                node.setOpponentWinPercent(100 - node.getWinPercent());
            } else {
                node.setWinPercent(100);
                node.setOpponentWinPercent(0);
            }
            return;
        }
        if (node.hasLeft()) {
            leftChild = node.getLeft();
            calculateWinPercents(leftChild);
            leftPercentToWin = leftChild.getOpponentWinPercent();
            leftOppenentPercentToWin = leftChild.getWinPercent();
        }
        if (node.hasLeft()) {
            rightChild = node.getRight();
            calculateWinPercents(rightChild);
            rightPercentToWin = rightChild.getOpponentWinPercent();
            rightOpponentPercentToWin = rightChild.getWinPercent();
        }

        if (leftChild != null && rightChild != null) {
            node.setWinPercent( (leftPercentToWin + rightPercentToWin) / 2 );
            node.setOpponentWinPercent( (leftOppenentPercentToWin + rightOpponentPercentToWin) / 2 );
        } else if (leftChild != null) {
            node.setWinPercent(leftPercentToWin);
            node.setOpponentWinPercent(leftOppenentPercentToWin);
        } else {
            node.setWinPercent(rightPercentToWin);
            node.setOpponentWinPercent(rightOpponentPercentToWin);
        }
    }

}
