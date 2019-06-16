package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

import java.util.List;

public class RacingGame implements Visualizable {

    private final RacingGameOption option;

    private int movedCount = Car.DEFAULT_POSITION;

    public RacingGame(final RacingGameOption option) {
        this.option = option;
    }

    public void move() {
        if (isComplete()) {
            throw new IllegalStateException("이미 결과가 나온 게임입니다.");
        }

        moveAllCar();
        movedCount++;
    }

    public boolean isComplete() {
        return movedCount == option.getMovingCount();
    }

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();
        for (final Car car : getCarList()) {
            visualBuilder.append(car.visualize())
                    .append(StringUtils.NEW_LINE);
        }

        return visualBuilder.toString();
    }

    private List<Car> getCarList() {
        return getParticipants().toList();
    }

    private Participants getParticipants() {
        return option.getParticipants();
    }

    private void moveAllCar() {
        getCarList().forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.moveForward();
    }
}
