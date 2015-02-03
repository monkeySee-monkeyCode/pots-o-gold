package game;

/**
 * @author marc.vis
 */
public class JulianPlayer implements Player {

    private Board board;

    public JulianPlayer(Board board) {
        /*
         * You can modify this however you want, depending on how
         * you want to track state
         */
        this.board = board;
    }

    /**
     * The name of the game
     *
     * TODO IMPLEMENT THIS METHOD TO BEAT MarcPlayer!!!
     *
     * @return value of item selected
     */
    public int move() {
        /*
         * Revise
         */
        return board.playLeft();
    }

    public Brotherman getPlayer() {
        return Brotherman.JULIAN;
    }

}
