package racinggame.ui;

import racinggame.domain.RacingGameResult;

import java.util.List;

public class RacingGameResultView {
    private static final String MAKER = "-";

    private final List<RacingGameResult> results;
    private final MessageWriter writer;

    public RacingGameResultView(final List<RacingGameResult> results, final MessageWriter writer) {
        this.results = results;
        this.writer = writer;
    }

    public void display() {
        writer.write("실행 결과");

        for (final RacingGameResult result : results) {
            displayCarPosition(result);
            writer.write("");
        }
    }

    private void displayCarPosition(final RacingGameResult result) {
        for (final int position : result.getResults()) {
            writer.write(MAKER.repeat(position));
        }
    }
}
