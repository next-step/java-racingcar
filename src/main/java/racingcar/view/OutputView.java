package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.game.CarStatus;
import racingcar.game.RoundResult;
import racingcar.game.RacingGameResult;

import java.util.List;

public class OutputView {
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
            String printValue = carStatus.getCarName() + " : " + StringUtils.repeat("-", carStatus.getPosition());
            System.out.println(printValue);
        });
    }

    private static void printWinners(RacingGameResult racingGameResult) {
        String winners = StringUtils.join(racingGameResult.getWinners(), ", ");
        DisplayText.OUTPUT_RESULT_WINNER.printMessage(winners);
    }
}
