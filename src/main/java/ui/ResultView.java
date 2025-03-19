package ui;

import domain.RacingGameResult;
import domain.RoundResult;

import java.io.PrintStream;
import java.util.List;

public class ResultView {
    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printResult(RacingGameResult result) {
        printStream.println("실행 결과");
        List<RoundResult> allRoundResults = result.getAllRoundResults();
        for (int i = 0; i < allRoundResults.size(); i++) {
            printRoundResult(allRoundResults, i);
        }
    }

    private void printRoundResult(List<RoundResult> allRoundResults, int i) {
        printRoundResult(allRoundResults.get(i));
        if (i < allRoundResults.size() - 1) printStream.println();
    }

    private void printRoundResult(RoundResult roundResult) {
        for (Integer position: roundResult.whereAreCars()) {
            printStream.println("-".repeat(position + 1));
        }
    }
}
