package game;

import game.julianplayerdomain.JulianPlayer;

/**
 * @author marc.vis
 */
public class PlayerFactory {

    public static Player buildPlayer(Brotherman player, Board board) {

        switch (player) {
            case JULIAN:
                return new JulianPlayer(board);
            case MARC:
                return new MarcPlayer(board);
            default:
                return null;
        }
    }
}
