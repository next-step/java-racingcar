package com.jaenyeong.mission2.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private Distance currDist;
    private List<Distance> history;

    public Car() {
        this.currDist = new Distance();
        this.history = new ArrayList<>();
    }

    public void move() {
        currDist = currDist.move();
        history.add(currDist);
    }

    public int getCurrentDistance() {
        return currDist.getDist();
    }

    public List<Integer> getRacingHistory() {
        return history.stream()
            .map(Distance::getDist)
            .collect(Collectors.toList());
    }
}
