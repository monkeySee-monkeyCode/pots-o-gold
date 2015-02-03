package game.marcplayerdomain;

import game.Board;
import game.LastPlayed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marc.vis
 */
public class Strategy {

    public enum Move {LEFT, RIGHT}

    private Node<MoveMetaData> root;
    private List<Move> playedMoves;

    public Strategy(Board board) {
        this.root = TreeBuilder.buildTree(board);
        playedMoves = new ArrayList<Move>();
    }

    public Move determineMove(LastPlayed lastPlayed) {
        switch (lastPlayed) {
            case LEFT:
                playedMoves.add(Move.LEFT);
                break;
            case RIGHT:
                playedMoves.add(Move.RIGHT);
        }

        Move move = Move.LEFT;

        Node<MoveMetaData> currentMove = determineCurrentMove();

        MoveMetaData leftMoveMetaData = (MoveMetaData)currentMove.getLeft().getMetaData();
        MoveMetaData rightMoveMetaData = (MoveMetaData)currentMove.getRight().getMetaData();

        if (leftMoveMetaData.getWinPercent() > rightMoveMetaData.getWinPercent()) {
            move = Move.LEFT;
        } else if (leftMoveMetaData.getWinPercent() < rightMoveMetaData.getWinPercent()) {
            move = Move.RIGHT;
        }
        /*
         * TODO implement margin + percentage logic here
         */

        playedMoves.add(move);
        return move;
    }

    @SuppressWarnings("unchecked")
    private Node<MoveMetaData> determineCurrentMove() {
        Node<MoveMetaData> currentMove = root;

        for (Move playedMove : playedMoves) {

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
