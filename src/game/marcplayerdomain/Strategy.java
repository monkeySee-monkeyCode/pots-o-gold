package game.marcplayerdomain;

import game.Board;
import game.LastPlayed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marc.vis
 */
public class Strategy {

    private Node root;
    private List<LastPlayed> playedMoves;

    public Strategy(Board board) {
        this.root = TreeBuilder.buildTree(board);
        playedMoves = new ArrayList<LastPlayed>();
    }

    public LastPlayed determineMove(LastPlayed lastPlayed) {
        switch (lastPlayed) {
            case LEFT:
                playedMoves.add(LastPlayed.LEFT);
                break;
            case RIGHT:
                playedMoves.add(LastPlayed.RIGHT);
        }

        LastPlayed move = LastPlayed.LEFT;

        Node currentMove = determineCurrentMove();

        if (!currentMove.isLeaf()) {
            int leftPercent = (currentMove.getLeftPositiveOutcomes() * 100)
                    / (currentMove.getLeftPositiveOutcomes() + currentMove.getLeftNegativeOutcomes());
            int rightPercent = (currentMove.getRightPositiveOutcomes() * 100)
                    / (currentMove.getRightPositiveOutcomes() + currentMove.getRightNegativeOutcomes());

            move = leftPercent > rightPercent ? LastPlayed.LEFT : LastPlayed.RIGHT;

        /*
         * TODO implement margin logic here
         */
        }

        playedMoves.add(move);
        return move;
    }

    private Node determineCurrentMove() {
        Node currentMove = root;

        for (LastPlayed playedMove : playedMoves) {

            switch (playedMove) {
                case LEFT:
                    currentMove = currentMove.getLeft();
                    break;
                case RIGHT:
                    currentMove = currentMove.getRight();
            }
        }
        return currentMove;
    }

}
