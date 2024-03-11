package racingcar.vo;

import java.util.List;

public class GameResult {

    private static final String LINE_BREAK = "\n";

    private final List<RoundResult> roundResults;

    private GameResult(final List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        this.roundResults.forEach(roundResult -> stringBuilder.append(roundResult).append(LINE_BREAK));

        return stringBuilder.toString();
    }

    public static GameResult from(final List<RoundResult> roundResults) {
        return new GameResult(roundResults);
    }
}
