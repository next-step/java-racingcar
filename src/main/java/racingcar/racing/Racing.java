package racingcar.racing;

import java.util.stream.IntStream;

public class Racing {
    private final Cars cars;
    private final int round;

    public Racing(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        IntStream.range(0, round).forEach(i -> cars.moveAll());
    }
}