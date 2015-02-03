package game.marcplayerdomain;

/**
 * @author marc.vis
 */
public class MoveMetaData {

    private int value = 0;

    private int currentScore = 0;
    private int opponentScore = 0;

    private int winPercent = 0;
    private int opponentWinPercent = 0;

    private int totalPositiveOutcomes = 0;
    private int totalNegativeOutcomes = 0;

    private int leftPositiveOutcomes = 0;
    private int leftNegativeOutcomes = 0;
    private int rightPositiveOutcomes = 0;
    private int rightNegativeOutcomes = 0;

    public MoveMetaData() {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{value:[");
        stringBuilder.append(value);
        stringBuilder.append("], currentScore:[");
        stringBuilder.append(currentScore);
        stringBuilder.append("], opponentScore:[");
        stringBuilder.append(opponentScore);
        stringBuilder.append("], winPercent:[");
        stringBuilder.append(winPercent);
        stringBuilder.append("], opponentWinPercent:[");
        stringBuilder.append(opponentWinPercent);
        stringBuilder.append("]}");

        return stringBuilder.toString();
    }

    public int getLeftPositiveOutcomes() {
        return leftPositiveOutcomes;
    }

    public void setLeftPositiveOutcomes(int leftPositiveOutcomes) {
        this.leftPositiveOutcomes = leftPositiveOutcomes;
    }

    public int getRightPositiveOutcomes() {
        return rightPositiveOutcomes;
    }

    public void setRightPositiveOutcomes(int rightPositiveOutcomes) {
        this.rightPositiveOutcomes = rightPositiveOutcomes;
    }

    public int getLeftNegativeOutcomes() {
        return leftNegativeOutcomes;
    }

    public void setLeftNegativeOutcomes(int leftNegativeOutcomes) {
        this.leftNegativeOutcomes = leftNegativeOutcomes;
    }

    public int getRightNegativeOutcomes() {
        return rightNegativeOutcomes;
    }

    public void setRightNegativeOutcomes(int rightNegativeOutcomes) {
        this.rightNegativeOutcomes = rightNegativeOutcomes;
    }

    public int getTotalPositiveOutcomes() {
        return totalPositiveOutcomes;
    }

    public void setTotalPositiveOutcomes(int totalPositiveOutcomes) {
        this.totalPositiveOutcomes = totalPositiveOutcomes;
    }

    public int getTotalNegativeOutcomes() {
        return totalNegativeOutcomes;
    }

    public void setTotalNegativeOutcomes(int totalNegativeOutcomes) {
        this.totalNegativeOutcomes = totalNegativeOutcomes;
    }
}
