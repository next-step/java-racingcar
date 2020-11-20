package race.view;

import race.domain.LapScore;
import race.domain.LapScores;

import java.io.PrintStream;
import java.util.List;
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

    public void showScoreBoard(List<LapScores> scores) {
        scores.forEach(this::showScores);
        if (!scores.isEmpty()) {
            showWinner(scores.get(scores.size() - 1));
        }
    }

    private void showScores(LapScores scores) {
        scores.forEach(score -> {
            out.print(score.getName() + " : ");
            out.println(POSITION_MARKER.repeat(score.getPosition() + 1));
        });
        out.println();
    }

    private void showWinner(LapScores scores) {
        String winners = scores.getFrontLine()
                .map(LapScore::getName)
                .collect(Collectors.joining(", "));
        out.println(winners + "가 최종 우승했습니다.");
    }
}
