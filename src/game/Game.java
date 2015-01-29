package game;

import java.util.Random;

/**
 * @author marc.vis
 *
 * Application is being used as an interactive tutorial to teach
 * a friend algorithm design
 */
public class Game {

    private static final Random rand = new Random();

    static int marcTotalScore = 0;
    static int julianTotalScore = 0;

    static int marcWins = 0;
    static int julianWins = 0;
    static int tieGames = 0;

    static int marcTotalBeatingPoints = 0;
    static int julianTotalBeatingPoints = 0;

    static int marcAverageScore;
    static int julianAverageScore;

    static int marcAverageBeatingPoints;
    static int julianAverageBeatingPoints;

    public static void main(String[] args) {
        /*
         * Protip: we should make this n a command line argument
         * instead of literal
         */
        int n = 100;
        Board[] boards = generateBoards(n);

        playSet(boards, Brotherman.MARC, Brotherman.JULIAN);
        clearResults();
        playSet(boards, Brotherman.JULIAN, Brotherman.MARC);
    }
    
    public static void playSet(Board[] boards, Brotherman first, Brotherman second) {

        for (int i = 0; i < boards.length; i++) {

            Board board = boards[i];

            Player firstPlayer = PlayerFactory.buildPlayer(first, board);
            Player secondPlayer = PlayerFactory.buildPlayer(second, board);

            int firstPlayerScore = 0;
            int secondPlayerScore = 0;

            while (board.isItemsLeft()) {
                firstPlayerScore += firstPlayer.move();
                secondPlayerScore += secondPlayer.move();
            }

            if (firstPlayerScore == secondPlayerScore) {
                tieGames++;
            } else if (firstPlayerScore > secondPlayerScore) {
                tabulateGame(firstPlayerScore, secondPlayerScore, firstPlayer.getPlayer());
            } else {
                tabulateGame(secondPlayerScore, firstPlayerScore, secondPlayer.getPlayer());
            }
        }

        finalizeResults(boards);
        printResults();
    }
    
    public static void clearResults() {
        marcTotalScore = 0;
        julianTotalScore = 0;

        marcWins = 0;
        julianWins = 0;
        tieGames = 0;

        marcTotalBeatingPoints = 0;
        julianTotalBeatingPoints = 0;
    }

    private static void tabulateGame(int winnerScore, int loserScore, Brotherman winner) {
        if (winner == Brotherman.MARC) {
            marcTotalScore += winnerScore;
            julianTotalScore += loserScore;
            marcWins++;
            marcTotalBeatingPoints += (winnerScore - loserScore);
        } else {
            marcTotalScore += loserScore;
            julianTotalScore += winnerScore;
            julianWins++;
            julianAverageBeatingPoints += (winnerScore - loserScore);
        }
    }

    private static void finalizeResults(Board[] boards) {
        marcAverageScore = marcTotalScore / ((boards.length - tieGames) / 2);
        marcAverageBeatingPoints = marcTotalBeatingPoints / marcWins;

        julianAverageScore = julianTotalScore / ((boards.length - tieGames) / 2);
        julianAverageBeatingPoints = julianTotalBeatingPoints / julianWins;
    }

    public static void printResults() {
        System.out.println("==================================================================================");
        System.out.println("Winner: " + (marcWins > julianWins ? "Marc" : "Julian"));
        System.out.println("\tBREAKDOWN");
        System.out.println("\t\t\tMarc\tJulian");
        System.out.println("Wins:\t\t" + marcWins + "\t" + julianWins);
        System.out.println("Avg Score:\t\t" + marcAverageScore + "\t" + julianAverageScore);
        System.out.println("Avg Delta:\t\t" + marcAverageBeatingPoints + "\t" + julianAverageBeatingPoints);
        System.out.println("==================================================================================");
    }

    private static Board[] generateBoards(int n) {
        Board[] boards = new Board[n];

        for (int i = 0; i < n; i++) {
            boards[i] = generateNewBoard();
        }
        return boards;
    }

    private static Board generateNewBoard() {
        int boardSize = ((rand.nextInt(25) + 4) / 2) * 2; //minimum 4 items and ensure even amount
        int[] board = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            board[i] = rand.nextInt(1000);
        }
        return new Board(board);
    }
}
