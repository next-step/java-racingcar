package ui;

import racing.GrandPrix;
import racing.Reports.ScoreBoard;

public class OutputView {
    private static final ScoreBoard consoleScoreBoard = new ConsoleScoreBoard();

    public static void printResult(GrandPrix grandPrix) {
        var reports = grandPrix.report();
        reports.print(consoleScoreBoard);
        System.out.println();
    }

    public static class ConsoleScoreBoard implements ScoreBoard {
        @Override
        public void print(int position) {
            System.out.println("-".repeat(position));
        }
    }
}
