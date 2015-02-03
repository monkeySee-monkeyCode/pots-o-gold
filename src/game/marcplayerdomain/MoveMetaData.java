package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class MoveMetaData {

    private int value;

    private int currentScore;
    private int opponentScore;

    private int winPercent;
    private int opponentWinPercent;

    public MoveMetaData() {
        this.value = 0;
    }

    public MoveMetaData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    public int getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(int winPercent) {
        this.winPercent = winPercent;
    }

    public int getOpponentWinPercent() {
        return opponentWinPercent;
    }

    public void setOpponentWinPercent(int opponentWinPercent) {
        this.opponentWinPercent = opponentWinPercent;
    }
}
