package race.view;

import race.domain.LapScore;
import race.domain.LapScores;
import race.domain.ResultEmitter;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView implements ResultEmitter {
    private static final String POSITION_MARKER = "-";

    protected final PrintStream out;

    public OutputView() {
        this(System.out);
    }

    public OutputView(PrintStream out) {
        this.out = out;
    }

    @Override
    public void emitScores(LapScores scores) {
        scores.forEach(score -> {
            out.print(score.getName() + " : ");
            out.println(POSITION_MARKER.repeat(score.getPosition() + 1));
        });
        out.println();
    }

    @Override
    public void emitWinner(LapScores scores) {
        String winners = scores.getFrontLine()
                .map(LapScore::getName)
                .collect(Collectors.joining(", "));
        out.println(winners + "가 최종 우승했습니다.");
    }
}
