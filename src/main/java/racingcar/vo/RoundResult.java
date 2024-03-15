package racingcar.vo;

import static java.text.MessageFormat.format;

import java.util.List;

public class RoundResult {

    private static final String ROUND_TITLE = "[Round {0}]";
    private static final String LINE_BREAK = "\n";

    private final int round;
    private final List<CarResult> carResults;

    public RoundResult(final int round, final List<CarResult> carResults) {
        this.round = round;
        this.carResults = carResults;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format(ROUND_TITLE, round)).append(LINE_BREAK);
        carResults.forEach(carResult -> stringBuilder.append(carResult).append(LINE_BREAK));

        return stringBuilder.toString();
    }
}
