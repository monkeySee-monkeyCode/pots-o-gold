package game.marcplayerdomain;

import game.Board;

/**
 * @author marc.vis
 */
public class TreeBuilder {

    public static Node<? extends MoveMetaData> buildTree(Board board) {

        int[] rawBoard = board.getBoardRaw();

        Node<MoveMetaData> root = new RootNode<MoveMetaData>();
        traceBoard(root, rawBoard, 0, rawBoard.length - 1);
        calculateScores(root, 0, 0);
        calculateWinPercents(root);

        return root;
    }

    public static void traceBoard(Node<? extends MoveMetaData> node, int[] board, int leftMost, int rightMost) {
        if (leftMost <= rightMost) {
            Node<MoveMetaData> leftChild = new Node<MoveMetaData>(new MoveMetaData(board[leftMost]));
            node.setLeft(leftChild);

            traceBoard(leftChild, board, leftMost + 1, rightMost);

            if (rightMost > leftMost) {
                Node<MoveMetaData> rightChild = new Node<MoveMetaData>(new MoveMetaData(board[rightMost]));
                node.setRight(rightChild);

                traceBoard(rightChild, board, leftMost, rightMost - 1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void calculateScores(Node<MoveMetaData> node, int currentScore,
                                        int opponentCurrentScore) {
        if (node.isLeaf()) {
            node.getMetaData().setCurrentScore(currentScore);
            node.getMetaData().setOpponentScore(opponentCurrentScore);
        } else {
            if (node.hasLeft()) {
                calculateScores(node.getLeft(), opponentCurrentScore, currentScore + node.getMetaData().getValue());
            }
            if (node.hasRight()) {
                calculateScores(node.getRight(), opponentCurrentScore, currentScore + node.getMetaData().getValue());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void calculateWinPercents(Node<MoveMetaData> node) {
        Node<MoveMetaData> leftChild = null;
        Node<MoveMetaData> rightChild = null;

        int leftPercentToWin = 0;
        int leftOppenentPercentToWin = 0;
        int rightPercentToWin = 0;
        int rightOpponentPercentToWin = 0;

        if (node.isLeaf()) {
            if (node.getParent() != null) {
                node.getMetaData().setWinPercent(node.getMetaData().getValue()
                        >= ((MoveMetaData)(node.getParent().getMetaData())).getValue() ? 100 : 0);
                node.getMetaData().setOpponentWinPercent(100 - node.getMetaData().getWinPercent());
            } else {
                node.getMetaData().setWinPercent(100);
                node.getMetaData().setOpponentWinPercent(0);
            }
            return;
        }
        if (node.hasLeft()) {
            leftChild = node.getLeft();
            calculateWinPercents(leftChild);
            leftPercentToWin = leftChild.getMetaData().getOpponentWinPercent();
            leftOppenentPercentToWin = leftChild.getMetaData().getWinPercent();
        }
        if (node.hasRight()) {
            rightChild = node.getRight();
            calculateWinPercents(rightChild);
            rightPercentToWin = rightChild.getMetaData().getOpponentWinPercent();
            rightOpponentPercentToWin = rightChild.getMetaData().getWinPercent();
        }

        if (leftChild != null && rightChild != null) {
            node.getMetaData().setWinPercent( (leftPercentToWin + rightPercentToWin) / 2 );
            node.getMetaData().setOpponentWinPercent( (leftOppenentPercentToWin + rightOpponentPercentToWin) / 2 );
        } else if (leftChild != null) {
            node.getMetaData().setWinPercent(leftPercentToWin);
            node.getMetaData().setOpponentWinPercent(leftOppenentPercentToWin);
        } else {
            node.getMetaData().setWinPercent(rightPercentToWin);
            node.getMetaData().setOpponentWinPercent(rightOpponentPercentToWin);
        }
    }

}
