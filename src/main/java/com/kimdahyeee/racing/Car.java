package com.kimdahyeee.racing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int GO_STRAIGHT_LIMIT = 4;

    public List<Integer> move(List<Integer> carPositions) {
        List<Integer> newPositions = new ArrayList<>();

        for (Integer carPosition : carPositions) {
            newPositions.add(moveOrStop(carPosition));
        }

        return newPositions;
    }

    protected Integer moveOrStop(Integer carPosition) {
        Integer position = carPosition;
        boolean canMove = getRandomNumber() >= GO_STRAIGHT_LIMIT;

        if (canMove) {
            return ++position;
        }

        return position;
    }

    protected int getRandomNumber() {
        return (int) ((Math.random() * 10) - 1);
    }
}
