package game;

/**
 * @author marc.vis
 */
public class Board {

    private int[] board;
    private int itemsRemaining;
    private int leftMost;
    private int rightMost;
    private LastPlayed lastPlayed;

    public Board(int[] board) {
        this.board = board;
        this.itemsRemaining = board.length;
        this.leftMost = 0;
        this.rightMost = board.length - 1;
        lastPlayed = LastPlayed.NEVER;
    }

    public boolean isItemsLeft() {
        return itemsRemaining > 0;
    }

    public int playLeft() {
        if (leftMost <= rightMost) {
            itemsRemaining--;
            lastPlayed = LastPlayed.LEFT;
            return board[leftMost++];
        }
        return 0;
    }

    public int playRight() {
        if (leftMost <= rightMost) {
            itemsRemaining--;
            lastPlayed = LastPlayed.RIGHT;
            return board[rightMost--];
        }
        return 0;
    }

    public int[] getBoardRaw() {
        return this.board;
    }

    public int getValue(int index) {
        if (index > 0 && index < board.length) {
            return board[index];
        }
        return 0;
    }

    public LastPlayed getLastPlayed() {
        return lastPlayed;
    }

}
