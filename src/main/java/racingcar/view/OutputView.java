package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.game.Result;
import racingcar.game.Results;

import java.util.List;

public class OutputView {
    public static void printResults(Results results) {
        DisplayText.OUTPUT_RESULT_TITLE.printMessage();
        List<Result> gameResult = results.getResults();
        gameResult.forEach(result -> {
            printResult(result);
            System.out.println();
        });

        printWinners(results);
    }

    private static void printResult(Result result) {
        List<String> statusList = result.getStatusList();
        statusList.forEach(System.out::println);
    }

    private static void printWinners(Results results) {
        String winners = StringUtils.join(results.getWinners(), ", ");
        DisplayText.OUTPUT_RESULT_WINNER.printMessage(winners);
    }
}
