package game.marcplayerdomain;

import game.Board;
import game.LastPlayed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marc.vis
 */
public class Strategy {

    private Node<MoveMetaData> root;
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

        LastPlayed move = null;

        Node<MoveMetaData> currentMove = determineCurrentMove();

        MoveMetaData leftMoveMetaData = (MoveMetaData)currentMove.getLeft().getMetaData();
        MoveMetaData rightMoveMetaData = (MoveMetaData)currentMove.getRight().getMetaData();

        if (leftMoveMetaData.getWinPercent() > rightMoveMetaData.getWinPercent()) {
            move = LastPlayed.LEFT;
        } else if (leftMoveMetaData.getWinPercent() < rightMoveMetaData.getWinPercent()) {
            move = LastPlayed.RIGHT;
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
