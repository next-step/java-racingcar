package racingcar.vo;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승 : {0}";
    private static final String LINE_BREAK = "\n";
    private static final String WINNER_NAME_DELIMITER = ", ";

    private final List<RoundResult> roundResults = new ArrayList<>();
    private List<String> winnerNames = new ArrayList<>();

    public void addRoundResult(final RoundResult roundResult) {
        this.roundResults.add(roundResult);
    }

    public void updateWinnerNames(final List<String> winnerNames) {
        this.winnerNames = winnerNames;
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
