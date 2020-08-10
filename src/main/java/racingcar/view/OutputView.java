package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.game.CarStatus;
import racingcar.game.RacingGameResult;
import racingcar.game.RoundResult;

import java.util.List;

public class OutputView {
    private static final String COMMA_WITH_SPACE = ", ";
    private static final String COLON_WITH_SPACE = " : ";
    private static final String PROGRESS_BAR = "-";

    public static void printResults(RacingGameResult racingGameResult) {
        DisplayText.OUTPUT_RESULT_TITLE.printMessage();
        List<RoundResult> gameRoundResult = racingGameResult.getRoundResults();
        gameRoundResult.forEach(result -> {
            printResult(result);
            System.out.println();
        });

        printWinners(racingGameResult);
    }

    private static void printResult(RoundResult roundResult) {
        List<CarStatus> statusList = roundResult.getCarStatuses();
        statusList.forEach(carStatus -> {
            String printValue = carStatus.getCarName() + COLON_WITH_SPACE + StringUtils.repeat(PROGRESS_BAR, carStatus.getPosition());
            System.out.println(printValue);
        });
    }

    private static void printWinners(RacingGameResult racingGameResult) {
        String winners = StringUtils.join(racingGameResult.getWinners(), COMMA_WITH_SPACE);
        DisplayText.OUTPUT_RESULT_WINNER.printMessage(winners);
    }
}
