package racingcar.view.util;

import java.text.MessageFormat;

import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class ConsoleResultFormatter implements ResultFormatter {

    private static final String CAR_RESULT_FORMAT = "{0} {1}\n";
    private static final String ROUND_TITLE = "[Round {0}]\n";
    private static final String WINNER_NOTIFICATION_FORMAT = "최종 우승 : {0}";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String LINE_BREAK = "\n";

    @Override
    public String formatGameResult(final GameResult gameResult) {
        final StringBuilder gameResultView = new StringBuilder();

        gameResult.roundResults()
                .forEach(roundResult -> gameResultView.append(formatRoundResult(roundResult)).append(LINE_BREAK));

        final String joinWinnerNames = String.join(WINNER_NAME_DELIMITER, gameResult.winnerNames());
        gameResultView.append(MessageFormat.format(WINNER_NOTIFICATION_FORMAT, joinWinnerNames));

        return gameResultView.toString();
    }

    private String formatRoundResult(final RoundResult roundResult) {
        final StringBuilder roundResultView = new StringBuilder();

        roundResultView.append(MessageFormat.format(ROUND_TITLE, roundResult.round()));
        roundResult.carResults()
                .forEach(carResult -> roundResultView.append(formatCarResult(carResult)));

        return roundResultView.toString();
    }

    private String formatCarResult(final CarResult carResult) {
        return MessageFormat.format(CAR_RESULT_FORMAT, carResult.name(), carResult.positionResult());
    }
}
