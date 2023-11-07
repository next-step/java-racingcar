package me.namuhuchutong.step4;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class OutputView {

    private static final String DELIMITER = ": ";
    private static final String MARKER = "-";

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
        System.out.println("\n***Winners***");
        winners.forEach(System.out::println);
    }
}
