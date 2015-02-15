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

    public void resetBoard() {
        itemsRemaining = board.length;
        leftMost = 0;
        rightMost = itemsRemaining - 1;
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

    public int peekLeft(){
        if (leftMost <= rightMost) {
            return board[leftMost];
        }
        return 0;
    }
    public int peekRight(){
        if (leftMost <= rightMost) {
            return board[rightMost];
        }
        return 0;
    }

    public int[] getBoardRaw() {
        return this.board;
    }

    public LastPlayed getLastPlayed() {
        return lastPlayed;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Board: [");

        for (int i = 0; i < board.length; i++) {
            stringBuilder.append(board[i]);
            if (i < board.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

}
