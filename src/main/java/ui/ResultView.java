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
        for (RoundResult allRoundResult : allRoundResults) {
            printRoundResult(allRoundResult);
            printStream.println();
        }
        printWinners(result.whoAreWinners());
    }

    private void printWinners(List<String> winners) {
        String winnersMessage = String.format("%s가 최종 우승했습니다.", String.join(", ", winners));
        printStream.println(winnersMessage);
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
