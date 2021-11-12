package carracingwinner.ui;

import carracingwinner.domain.Result;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public void printResults(List<Result> results) {
        System.out.println(RESULT_MESSAGE);
        results.forEach(result -> {
            System.out.println(result.getResult());
        });
    }

    public void printWinners(List<String> winners) {
        String winner = winners.stream()
                .collect(Collectors.joining(","));
        System.out.printf(WINNER_MESSAGE, winner);
    }

}
