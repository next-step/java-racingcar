package com.kkambi.racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners;

    public void chooseWinners(List<Car> cars) {
        Car maxLocationCar = Collections.max(cars);
        this.winners = cars.stream()
                .filter(car -> car.equals(maxLocationCar))
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return winners;
    }
}
