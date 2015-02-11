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

        boolean isFirstPlayer = isFirstPlayer();
        LastPlayed move = LastPlayed.LEFT;

        Node currentMove = determineCurrentMove();
        Node leftMove = currentMove.getLeft() != null ? currentMove.getLeft() : new Node();
        Node rightMove = currentMove.getRight() != null ? currentMove.getRight() : new Node();

        int leftWinMargin = 0;
        int rightWinMargin = 0;

        if (isFirstPlayer) {
            leftWinMargin = leftMove.getFirstPlayerPositiveOutcomes() - leftMove.getSecondPlayerPositiveOutcomes();
            rightWinMargin = rightMove.getFirstPlayerPositiveOutcomes() - rightMove.getSecondPlayerPositiveOutcomes();
        } else {
            leftWinMargin = leftMove.getSecondPlayerPositiveOutcomes() - leftMove.getFirstPlayerPositiveOutcomes();
            rightWinMargin = rightMove.getSecondPlayerPositiveOutcomes() - rightMove.getFirstPlayerPositiveOutcomes();
        }

        if (rightWinMargin > leftWinMargin) {
            move = LastPlayed.RIGHT;
        }

        playedMoves.add(move);
        return move;
    }

    private boolean isFirstPlayer() {
        return playedMoves.isEmpty() || (playedMoves.size() % 2 == 0);
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
