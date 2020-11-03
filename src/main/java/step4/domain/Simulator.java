package step4.domain;

import java.util.stream.IntStream;

public class Simulator {
    private final Cars cars;
    private final Integer tryCount;

    public Simulator(Integer tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void execute(RacingStrategy racingStrategy) {
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    cars.move(racingStrategy);
                });
    }

}
