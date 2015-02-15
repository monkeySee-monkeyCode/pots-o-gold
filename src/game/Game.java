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

    static int marcTotalWins = 0;
    static int julianTotalWins = 0;

    public static void main(String[] args) {
        /*
         * Protip: we should make this n a command line argument
         * instead of literal
         */
        int n = 100;
        Board[] boards = generateBoards(n);

        playSet(boards, Brotherman.MARC, Brotherman.JULIAN);
        clearResults();
        clearBoards(boards);
        playSet(boards, Brotherman.JULIAN, Brotherman.MARC);

        showTotalOutcome();
    }
    
    public static void playSet(Board[] boards, Brotherman first, Brotherman second) {

        for (Board board : boards) {

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

    private static void clearBoards(Board[] boards) {
        for (Board board : boards) {
            board.resetBoard();
        }
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
            julianTotalBeatingPoints += (winnerScore - loserScore);
        }

        printGameScore(winnerScore, loserScore, winner);
    }

    private static void printGameScore(int winnerScore, int loserScore, Brotherman winner) {
        String winnerName = "Marc";
        int julianPoints = loserScore;
        int marcPoints = winnerScore;
        if (winner == Brotherman.JULIAN) {
            winnerName = "Julian";
            julianPoints = winnerScore;
            marcPoints = loserScore;
        }
        System.out.println("\t*************************");
        System.out.println("\tGame winner: " + winnerName + "\n\tMarc points:\t"
                + marcPoints + "\n\tJulian points:\t" + julianPoints);
        System.out.println("\t*************************");
    }

    private static void finalizeResults(Board[] boards) {
        marcAverageScore = marcTotalScore / ((boards.length - tieGames) / 2);
        if (marcWins > 0) {
            marcAverageBeatingPoints = marcTotalBeatingPoints / marcWins;
        }

        julianAverageScore = julianTotalScore / ((boards.length - tieGames) / 2);
        if (julianWins > 0) {
            julianAverageBeatingPoints = julianTotalBeatingPoints / julianWins;
        }

        marcTotalWins += marcWins;
        julianTotalWins += julianWins;
    }

    public static void printResults() {
        System.out.println("==================================================================================");
        System.out.println("Winner: " + (marcWins > julianWins ? "Marc" : "Julian"));
        System.out.println("BREAKDOWN");
        System.out.println("\t\t\t\tMarc\tJulian");
        System.out.println("Wins:\t\t\t" + marcWins + "\t\t" + julianWins);
        System.out.println("Ties:\t\t\t" + tieGames);
        System.out.println("Avg Score:\t\t" + marcAverageScore + "\t" + julianAverageScore);
        System.out.println("Avg Delta:\t\t" + marcAverageBeatingPoints + "\t\t" + julianAverageBeatingPoints);
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
        int boardSize = ((rand.nextInt(10) + 4) / 2) * 2; //minimum 4 items and ensure even amount
        int[] board = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            board[i] = rand.nextInt(1000);
        }
        return new Board(board);
    }

    private static void showTotalOutcome() {
        System.out.println("Marc Total Wins: " + marcTotalWins);
        System.out.println("Julian Total Wins: " + julianTotalWins);
    }
}
