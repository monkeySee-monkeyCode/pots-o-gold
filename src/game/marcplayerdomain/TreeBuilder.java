package game.marcplayerdomain;

import game.Board;

/**
 * @author marc.vis
 */
public class TreeBuilder {

    public static Node buildTree(Board board) {
        int[] rawBoard = board.getBoardRaw();

        Node root = new RootNode();

        traceBoard(root, rawBoard, 0, rawBoard.length - 1);

        calculateScores(root.getLeft(), 0, 0, true);
        calculateScores(root.getRight(), 0, 0, true);

        calculateOutcomes(root);

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

    public static void calculateScores(Node node, int firstPlayerScore, int secondPlayerScore, boolean isFirstPlayer) {
        if (node != null) {
            int fps, sps;

            if (isFirstPlayer) {
                fps = firstPlayerScore + node.getValue();
                sps = secondPlayerScore;
            } else {
                fps = firstPlayerScore;
                sps = secondPlayerScore + node.getValue();
            }

            node.setFirstPlayerScore(fps);
            node.setSecondPlayerScore(sps);

            calculateScores(node.getLeft(), fps, sps, !isFirstPlayer);
        }
    }

    public static void calculateOutcomes(Node node) {
        if (node != null) {
            if (node.isLeaf()) {
                // Tie means no positive or negative outcomes
                if (node.getFirstPlayerScore() > node.getSecondPlayerScore()) {
                    node.setFirstPlayerPositiveOutcomes(1);
                    node.setSecondPlayerNegativeOutcomes(1);
                } else if (node.getFirstPlayerScore() < node.getSecondPlayerScore()) {
                    node.setFirstPlayerNegativeOutcomes(1);
                    node.setSecondPlayerPositiveOutcomes(1);
                }
            } else {
                calculateOutcomes(node.getLeft());
                calculateOutcomes(node.getRight());

                Node left = node.getLeft() != null ? node.getLeft() : new Node();
                Node right = node.getRight() != null ? node.getRight() : new Node();

                node.setFirstPlayerPositiveOutcomes(left.getFirstPlayerPositiveOutcomes()
                        + right.getFirstPlayerPositiveOutcomes());
                node.setFirstPlayerNegativeOutcomes(left.getFirstPlayerNegativeOutcomes()
                        + right.getFirstPlayerNegativeOutcomes());
                node.setSecondPlayerPositiveOutcomes(left.getSecondPlayerPositiveOutcomes()
                        + right.getSecondPlayerPositiveOutcomes());
                node.setSecondPlayerNegativeOutcomes(left.getSecondPlayerNegativeOutcomes()
                        + right.getSecondPlayerNegativeOutcomes());
            }
        }
    }
}
