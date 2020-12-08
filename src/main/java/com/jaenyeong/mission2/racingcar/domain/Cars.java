package com.jaenyeong.mission2.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final int howManyRacingCars) {
        this.racingCars = new ArrayList<>();
        for (int car = 0; car < howManyRacingCars; car++) {
            this.racingCars.add(new Car());
        }
    }

    public int getHowManyRacingCars() {
        return this.racingCars.size();
    }

    public void moveRacingCars() {
        racingCars.forEach(Car::move);
    }

    public List<Integer> getDistanceRacingCars() {
        return racingCars.stream()
            .map(Car::getCurrentDistance)
            .collect(Collectors.toList());
    }

    public List<List<Integer>> getRaceHistoriesForAllCars() {
        return racingCars.stream()
            .map(Car::getRacingHistory)
            .collect(Collectors.toList());
    }
}
