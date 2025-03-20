package ui;

import domain.RacingCarCurrentStatus;
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
            printRoundResult(allRoundResults.get(i));
            printEmptyLineBetweenRounds(i, allRoundResults.size());
        }
    }

    private void printEmptyLineBetweenRounds(int i, int size) {
        if (i < size- 1) printStream.println();
    }

    private void printRoundResult(RoundResult roundResult) {
        for (RacingCarCurrentStatus status: roundResult.getRaceProgress()) {
            printStream.println(formatCarResult(status));
        }
    }

    private String formatCarResult(RacingCarCurrentStatus status) {
        String dashes = "-".repeat(status.whereIsThisCarNow() + 1);
        return status.whatNameIsThisCar() + ":" + dashes;
    }
}
