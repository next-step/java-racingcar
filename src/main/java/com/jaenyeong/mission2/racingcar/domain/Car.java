package com.jaenyeong.mission2.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private List<Distance> history;

    public Car() {
        this.history = new ArrayList<>();
        this.history.add(new Distance());
    }

    public void move() {
        history.add(getLastDistance().move());
    }

    private Distance getLastDistance() {
        return history.get(history.size() - 1);
    }

    public int getCurrentDistance() {
        return getLastDistance().getDist();
    }

    public List<Integer> getRacingHistory() {
        return history.stream()
            .map(Distance::getDist)
            .collect(Collectors.toList());
    }
}
