package game;

import game.marcplayerdomain.Strategy;

/**
 * @author marc.vis
 */
public class MarcPlayer implements Player {

    /*
     * This is where I'll be implementing my player
     */

    private Board board;
    private Strategy strategy;

    public MarcPlayer(Board board) {
        this.board = board;
        this.strategy = new Strategy(board);
    }

    /**
     * Switch line comments to turn on and off mocking
     *
     * @return
     */
    public int move() {
        return moveStrategy();
        // return moveMock();
    }

    private int moveMock() {
        return board.playRight();
    }

    public int moveStrategy() {
        LastPlayed lastPlayed = board.getLastPlayed();

        LastPlayed move = strategy.determineMove(lastPlayed);

        switch (move) {
            case LEFT:
                return board.playLeft();
            case RIGHT:
                return board.playRight();
            default:
                return 0;
        }
    }

    public Brotherman getPlayer() {
        return Brotherman.MARC;
    }
}
