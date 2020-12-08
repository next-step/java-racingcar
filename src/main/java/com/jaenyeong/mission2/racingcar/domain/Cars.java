package com.jaenyeong.mission2.racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final List<String> namesOfCars) {
        this.racingCars = new ArrayList<>();
        for (String name : namesOfCars) {
            this.racingCars.add(new Car(name));
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

    public Map<String, List<Integer>> getRaceHistoriesForAllCars() {
        final Map<String, List<Integer>> history = new HashMap<>();

        for (Car c : racingCars) {
            history.put(c.getName(), c.getRacingHistory());
        }

        return history;
    }

    public List<String> getWinners() {
        final List<String> winners = new ArrayList<>();

        final int winDist = getWinDistance();

        for (Car c : racingCars) {
            if (winDist <= c.getCurrentDistance()) {
                winners.add(c.getName());
            }
        }

        return winners;
    }

    protected int getWinDistance() {
        return Collections.max(
            this.racingCars.stream()
                .map(Car::getCurrentDistance)
                .collect(Collectors.toList()));
    }
}
