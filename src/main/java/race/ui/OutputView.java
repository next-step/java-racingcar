package race.ui;

import race.logic.LapScore;
import race.logic.LapScores;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {
    private static final String POSITION_MARKER = "-";

    protected final PrintStream out;

    public OutputView() {
        this(System.out);
    }

    public OutputView(PrintStream out) {
        this.out = out;
    }

    public void showScore(LapScores scores) {
        scores.forEach(score -> {
            out.print(score.getName() + " : ");
            out.println(POSITION_MARKER.repeat(score.getPosition() + 1));
        });
        out.println();
    }

    public void showWinner(LapScores scores) {
        String winners = scores.getFrontLine()
                .map(LapScore::getName)
                .collect(Collectors.joining(", "));
        out.println(winners + "가 최종 우승했습니다.");
    }
}
