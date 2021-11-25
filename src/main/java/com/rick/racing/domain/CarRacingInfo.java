package com.rick.racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingInfo {

    public static final int START_TRY_COUNT = 1;
    private final CarGroup carGroup;
    private final TryCount tryCount;
    private TryCount currentTryCount;

    private CarRacingInfo(final List<Car> carGroup, final int tryCount) {
        this.carGroup = CarGroup.create(carGroup);
        this.tryCount = TryCount.create(tryCount);
        this.currentTryCount = TryCount.create(START_TRY_COUNT);
    }

    public static CarRacingInfo create(final List<String> carNames, final int tryCount) {
        List<Car> cars = carNames.stream()
            .map(Car::create)
            .collect(Collectors.toList());

        return new CarRacingInfo(cars, tryCount);
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public TryCount getTryCount() {
        return tryCount;
    }

    public boolean doRound() {
        boolean isDone = tryCount.equals(currentTryCount);
        this.currentTryCount = currentTryCount.increase();
        return !isDone;
    }
}
