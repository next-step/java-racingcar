package edu.nextstep.racingcar.step3.app;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Cars extends ArrayList<Car> {

    public void play(int numberOfAttempts) {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt(Cars.this));
    }

    private void attempt(Cars cars) {
        cars.forEach(Car::move);
    }
}
