package me.namuhuchutong.step3;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {

    private static final String MARKER = "-";

    public void printResult(RacingResult racingResult) {
        printThroughStandardOut(racingResult);
    }

    private void printThroughStandardOut(RacingResult racingResult) {
        List<Cars> values = racingResult.getValues();
        values.stream()
              .flatMap(this::flatCarsAndPrintNewLine)
              .map(car -> MARKER.repeat(car.getPosition()))
              .forEach(System.out::println);
    }

    private Stream<? extends Car> flatCarsAndPrintNewLine(Cars cars) {
        System.out.println();
        return cars.getCars().stream();
    }
}
