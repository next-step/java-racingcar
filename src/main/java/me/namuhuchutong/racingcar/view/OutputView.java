package me.namuhuchutong.racingcar.view;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import me.namuhuchutong.racingcar.domain.Car;
import me.namuhuchutong.racingcar.domain.Cars;
import me.namuhuchutong.racingcar.dto.RacingResult;

public class OutputView {

    private static final String DELIMITER = ": ";
    private static final String MARKER = "-";
    private static final String WINNER_BANNER = "\n***Winners***";

    public void printResult(RacingResult racingResult) {
        racingResult.getValues().stream()
                                .flatMap(this::flatCarsAndPrintNewLine)
                                .map(createResultString())
                                .forEach(System.out::println);
        printWinner(racingResult.getWinners());
    }

    private Function<Car, String> createResultString() {
        return car -> {
            String name = car.getName();
            String position = MARKER.repeat(car.getPosition());
            return name + DELIMITER + position;
        };
    }

    private Stream<Car> flatCarsAndPrintNewLine(Cars cars) {
        System.out.println();
        return cars.getValues().stream();
    }

    private void printWinner(List<String> winners) {
        System.out.println(WINNER_BANNER);
        winners.forEach(System.out::println);
    }
}
