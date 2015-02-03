package game.marcplayerdomain;

import game.Board;

/**
 * @author marc.vis
 */
public class TreeBuilder {

    public static Node buildTree(Board board) {

        System.out.println("Building tree for board: " + board);

        int[] rawBoard = board.getBoardRaw();

        Node root = new RootNode();

        traceBoard(root, rawBoard, 0, rawBoard.length - 1);
        calculateScores(root, 0, 0);
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

    private static void calculateScores(Node node, int currentScore,
                                        int opponentCurrentScore) {
        node.setCurrentScore(currentScore + node.getValue());
        node.setOpponentScore(opponentCurrentScore);
        if (node.hasLeft()) {
            calculateScores(node.getLeft(), opponentCurrentScore, currentScore + node.getValue());
        }
        if (node.hasRight()) {
            calculateScores(node.getRight(), opponentCurrentScore, currentScore + node.getValue());
        }
    }

    /**
     * Calculates outcomes on a per node basis.
     *
     * Explanation: For any node, I assume it is my move, so that I don't
     * need to track whose move it is.  If the played moves leads me to a node, I
     * can use it consistently.  The total positive moves is an arbitrary metric that
     * I may or may not use in the final algorithm, but the left and right metrics allow me
     * to determine proper win likelihood at a random choice event
     *
     * @param root
     */
    private static void calculateOutcomes(Node root) {
        if (root.isLeaf()) {
            if (root.getCurrentScore() > root.getOpponentScore()) {
                root.setTotalPositiveOutcomes(1);
                root.setTotalNegativeOutcomes(0);
            } else {
                root.setTotalPositiveOutcomes(0);
                root.setTotalNegativeOutcomes(1);
            }
        }
        else {
            int totalPositiveOutcomes = 0;
            int totalNegativeOutcomes = 0;
            int leftPositiveOutcomes = 0;
            int leftNegativeOutcomes = 0;
            int rightPositiveOutcomes = 0;
            int rightNegativeOutcomes = 0;

            if (root.hasLeft()) {
                Node left = root.getLeft();
                calculateOutcomes(left);
                leftNegativeOutcomes += left.getTotalPositiveOutcomes();
                leftPositiveOutcomes += left.getTotalNegativeOutcomes();
            }
            if (root.hasRight()) {
                Node right = root.getRight();
                calculateOutcomes(right);
                rightNegativeOutcomes += right.getTotalPositiveOutcomes();
                rightPositiveOutcomes += right.getTotalNegativeOutcomes();
            }

            totalPositiveOutcomes = leftPositiveOutcomes + rightPositiveOutcomes;
            totalNegativeOutcomes = leftNegativeOutcomes + rightNegativeOutcomes;

            root.setTotalPositiveOutcomes(totalPositiveOutcomes);
            root.setTotalNegativeOutcomes(totalNegativeOutcomes);

            root.setLeftPositiveOutcomes(leftPositiveOutcomes);
            root.setLeftNegativeOutcomes(leftNegativeOutcomes);

            root.setRightPositiveOutcomes(rightPositiveOutcomes);
            root.setRightNegativeOutcomes(rightNegativeOutcomes);
        }
    }
}
