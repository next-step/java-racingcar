package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class CarFactory {

    private final int count;
    private final RandomEngine engine;

    private CarFactory(int count, RandomEngine engine) {
        validateCount(count);
        Assert.notNull(engine, "'engine' must not be null");
        this.count = count;
        this.engine = engine;
    }

    public static CarFactory of(int count, RandomEngine engine) {
        return new CarFactory(count, engine);
    }

    RacingCars cars() {
        return RacingCars.from(
                IntStream.range(0, count)
                        .mapToObj(index -> RacingCar.from(engine))
                        .collect(Collectors.toList())
        );
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(String.format("'count'(%d) must not be negative", count));
        }
    }

    @Override
    public String toString() {
        return "CarFactory{" +
                "count=" + count +
                ", engine=" + engine +
                '}';
    }
}
