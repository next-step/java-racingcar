package com.jaenyeong.mission2.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    public static final int NAME_VALID_SIZE = 5;
    private String name;
    private List<Distance> history;

    public Car() {
        this.history = new ArrayList<>();
    }

    public Car(final String name) {
        if ((name == null) || (name.trim().isEmpty())
            || (name.trim().length() > NAME_VALID_SIZE)) {
            throw new IllegalArgumentException("invalid name");
        }

        this.history = new ArrayList<>();
        this.name = name.trim();
    }

    private Car(final String name, List<Distance> history) {
        this.name = name;
        this.history = new ArrayList<>(history);
    }

    public void move() {
        history.add(getLastDistance().move());
    }

    private Distance getLastDistance() {
        if (history.size() <= 0) {
            return new Distance();
        }

        return history.get(history.size() - 1);
    }

    public List<Integer> getRacingHistory() {
        return history.stream()
            .map(Distance::getDist)
            .collect(Collectors.toList());
    }

    public int getCurrentDistance() {
        return getLastDistance().getDist();
    }

    public Car copyCar() {
        return new Car(this.name, this.history);
    }

    public String getName() {
        return name;
    }
}
