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

    private Node root;
    private List<Move> playedMoves;

    public Strategy(Board board) {
        this.root = TreeBuilder.buildTree(board.getBoardRaw());
        playedMoves = new ArrayList<Move>();
    }

    public Move determineMove(LastPlayed lastPlayed) {
        return null;
    }

}
