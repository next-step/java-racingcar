package com.next.step.step3.domain;

import java.util.List;

public class Winner {

    private final int maxPosition;

    private Cars cars;

    public Winner(Cars cars) {
        this.maxPosition = cars.findMaxPosition();
        this.cars = cars;
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNames(maxPosition);
    }
}
