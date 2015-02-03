package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class RootNode<T> extends Node<T> {

    public RootNode() {
        super(null);
    }

    @Override
    public boolean isRoot() {
        return true;
    }
}
