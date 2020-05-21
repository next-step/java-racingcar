package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printOutResult(List<String> gameResults) {
        gameResults.forEach(gameResult -> System.out.println(gameResult + "\n"));
    }

    public static void printOutWinner(Cars winners) {
        String winnerNames = winners.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
