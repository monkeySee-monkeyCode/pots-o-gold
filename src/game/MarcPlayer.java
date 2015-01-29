package game;

/**
 * @author marc.vis
 */
public class MarcPlayer implements Player {

    /*
     * This is where I'll be implementing my player
     */

    private Board board;

    public MarcPlayer(Board board) {
        this.board = board;
    }

    /**
     * The name of the game
     *
     * TODO IMPLEMENT THIS METHOD TO BEAT JulianPlayer!!!
     *
     * @return value of item selected
     */
    public int move() {
        return 0;
    }

    public Brotherman getPlayer() {
        return Brotherman.MARC;
    }
}
