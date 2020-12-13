package study.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printRacingResult(RacingResult racingResult) {
        racingResult.getResults()
            .forEach(this::printCarResult);
        System.out.println();

    }

    public void printCarResult(Car car) {
        System.out.printf("%s: ", car.getName());
        for (int i = 0; i <= car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        System.out.printf("%s 가 최종 우승했습니다.\n", winnerNames);

    }
}
