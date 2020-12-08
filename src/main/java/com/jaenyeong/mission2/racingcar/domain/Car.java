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
        this.history.add(new Distance());
    }

    public Car(final String name) {
        if ((name == null) || (name.trim().isEmpty())
            || (name.trim().length() > NAME_VALID_SIZE)) {
            throw new IllegalArgumentException("invalid name");
        }

        this.history = new ArrayList<>();
        this.history.add(new Distance());
        this.name = name.trim();
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

    public String getName() {
        return name;
    }
}
