package game;

/**
 * @author marc.vis
 */
public interface Player {

    /**
     * Your player should make a selection, either left
     * or right
     *
     * @return              the value of the pot of gold
     *                          your player selected
     */
    int move();

    Brotherman getPlayer();
}
