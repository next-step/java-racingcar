package racingcar.view;

import racingcar.game.Result;
import racingcar.game.Results;

import java.util.List;

public class OutputView {
    public static void printResults(Results results) {
        System.out.println("실행 결과");
        List<Result> gameResult = results.getResults();
        gameResult.forEach(result -> {
            printResult(result);
            System.out.println();
        });
    }

    private static void printResult(Result result) {
        List<String> statusList = result.getStatusList();
        statusList.forEach(System.out::println);
    }
}
