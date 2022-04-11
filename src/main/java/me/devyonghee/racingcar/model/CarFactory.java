package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class CarFactory {

    private final int count;
    private final MovementPolicy policy;

    private CarFactory(int count, MovementPolicy policy) {
        validateCount(count);
        Assert.notNull(policy, "'policy' must not be null");
        this.count = count;
        this.policy = policy;
    }

    public static CarFactory of(int count, MovementPolicy policy) {
        return new CarFactory(count, policy);
    }

    RacingCars cars() {
        return RacingCars.from(
                IntStream.range(0, count)
                        .mapToObj(index -> RacingCar.from(policy))
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
                ", policy=" + policy +
                '}';
    }
}
