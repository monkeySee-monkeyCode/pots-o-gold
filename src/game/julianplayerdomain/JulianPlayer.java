package game.julianplayerdomain;

import game.Board;
import game.Brotherman;
import game.Player;

public class JulianPlayer implements Player {

    private Board board;
    private Strategery strategery;

    public JulianPlayer(Board board) {

            this.board = board;
            this.strategery = new Strategery();
    }

    /**
     * The name of the game
     *
     * TODO IMPLEMENT THIS METHOD TO BEAT MarcPlayer!!!
     *
     * @return value of item selected
     */
    public int move() {

        if (board.peekLeft() > board.peekRight()) {
            return board.playLeft();
        }
        return board.playRight();
    }





    public Brotherman getPlayer() {
        return Brotherman.JULIAN;
    }

}
