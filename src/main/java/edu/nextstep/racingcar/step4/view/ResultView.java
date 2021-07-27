package edu.nextstep.racingcar.step4.view;

import edu.nextstep.racingcar.step4.domain.Car;
import edu.nextstep.racingcar.step4.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String DISPLAY_TOKEN = "-";
    private static final String NEW_LINE = "\n";

    public void output(int numberOfAttempts, Cars cars) {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt(cars));
    }

    private void attempt(Cars cars) {
        cars.getCars().forEach(this::outputDistance);
        System.out.print(NEW_LINE);
    }

    private void outputDistance(Car car) {
        System.out.printf("%s : ", car.getName());
        IntStream.range(0, car.getDistance()).forEach(distanceIdx -> System.out.print(DISPLAY_TOKEN));
        System.out.print(NEW_LINE);
    }

    public void outputWinners(List<String> winners) {
        System.out.printf("%s 가 최종 우승했습니다.", String.join(",", winners));
    }
}
