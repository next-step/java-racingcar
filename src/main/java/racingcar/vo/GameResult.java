package racingcar.vo;

import static java.text.MessageFormat.format;

import java.util.List;

public class GameResult {

    private static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승 : {0}";
    private static final String LINE_BREAK = "\n";
    private static final String WINNER_NAME_DELIMITER = ", ";

    private final List<RoundResult> roundResults;
    private final List<String> winnerNames;

    public GameResult(final List<RoundResult> roundResults, final List<String> winnerNames) {
        this.roundResults = roundResults;
        this.winnerNames = winnerNames;
    }

    public List<String> winnerNames() {
        return this.winnerNames;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        this.roundResults.forEach(roundResult -> stringBuilder.append(roundResult).append(LINE_BREAK));

        final String joinWinnerNames = String.join(WINNER_NAME_DELIMITER, this.winnerNames);
        stringBuilder.append(format(WINNER_NOTIFICATION_MESSAGE, joinWinnerNames));

        return stringBuilder.toString();
    }
}
