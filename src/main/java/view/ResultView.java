package view;

import domain.RacingGameResult;

import java.io.PrintStream;
import java.util.List;

public class ResultView {
    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printResult(RacingGameResult result) {
        RacingGameResultFormatter racingGameResultFormatter = result.generateFormatter();
        printStream.print(racingGameResultFormatter.formatRacingGameResult());
        printWinners(result.whoAreWinners());
    }

    private void printWinners(List<String> winners) {
        String winnersMessage = String.format("%s가 최종 우승했습니다.", String.join(", ", winners));
        printStream.println(winnersMessage);
    }
}
