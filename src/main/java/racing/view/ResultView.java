package racing.view;

import racing.model.Car;

import racing.model.Racing;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_DELIMITER = " : ";
    private final String RESULT_MESSAGE = "실행결과";
    private final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(List<Map.Entry<String, Integer>> racingResult) {

        for (Map.Entry<String, Integer> moveInfo : racingResult) {
            System.out.print(moveInfo.getKey() + RESULT_DELIMITER);
            IntStream.rangeClosed(0, moveInfo.getValue()).forEach(x -> System.out.print("-"));
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_MESSAGE);
    }
}
