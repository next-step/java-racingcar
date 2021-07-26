package edu.nextstep.racingcar.step3.view;

import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Cars;

import java.util.stream.IntStream;

public class ResultView {

    private static final String DISPLAY_TOKEN = "-";
    private static final String NEW_LINE = "\n";

    public void print(int numberOfAttempts, Cars cars) {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt(cars));
    }

    private void attempt(Cars cars) {
        cars.forEach(this::printDistance);
        System.out.print(NEW_LINE);
    }

    private void printDistance(Car car) {
        IntStream.range(0, car.getDistance()).forEach(distanceIdx -> System.out.print(DISPLAY_TOKEN));
        System.out.print(NEW_LINE);
    }
}
