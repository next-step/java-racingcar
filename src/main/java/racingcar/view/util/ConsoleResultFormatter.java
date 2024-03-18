package racingcar.view.util;

import java.text.MessageFormat;

import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class ConsoleResultFormatter implements ResultFormatter {

    private static final String CAR_RESULT_FORMAT = "{0} {1}\n";
    private static final String CAR_POSITION_ICON = "-";
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
        final String winnerNotification = MessageFormat.format(WINNER_NOTIFICATION_FORMAT, joinWinnerNames);
        gameResultView.append(winnerNotification);

        return gameResultView.toString();
    }

    private String formatRoundResult(final RoundResult roundResult) {
        final StringBuilder roundResultView = new StringBuilder();
        final String roundTitle = MessageFormat.format(ROUND_TITLE, roundResult.round());
        roundResultView.append(roundTitle);

        roundResult.carResults()
                .forEach(carResult -> roundResultView.append(formatCarResult(carResult)));

        return roundResultView.toString();
    }

    private String formatCarResult(final CarResult carResult) {
        final StringBuilder carResultView = new StringBuilder();
        final String positionIcons = CAR_POSITION_ICON.repeat(carResult.position());

        carResultView.append(MessageFormat.format(CAR_RESULT_FORMAT, carResult.name(), positionIcons));

        return carResultView.toString();
    }
}
