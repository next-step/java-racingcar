package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class CarPreparer {

    private final CarFactory factory;
    private final Distance initialDistance;

    private CarPreparer(CarFactory factory, Distance initialDistance) {
        Assert.notNull(factory, "'factory' must not be null");
        Assert.notNull(initialDistance, "'initialDistance' must not be null");
        this.factory = factory;
        this.initialDistance = initialDistance;
    }

    public static CarPreparer of(CarFactory factory, Distance initialDistance) {
        return new CarPreparer(factory, initialDistance);
    }

    Tracks tracks() {
        return Tracks.from(factory.cars()
                .map(racingCar -> Track.of(racingCar, initialDistance)));
    }

    @Override
    public String toString() {
        return "CarPreparer{" +
                "factory=" + factory +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
