package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class RootNode extends Node {

    public RootNode() {
        super(0);
    }

    @Override
    public boolean isRoot() {
        return true;
    }
}
