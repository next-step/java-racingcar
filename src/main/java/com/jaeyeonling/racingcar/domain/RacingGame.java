package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.RandomUtils;
import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

import java.util.List;

public class RacingGame implements Visualizable {

    private static final int MOVING_RANDOM_BOUND = 9;

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

    public RacingGameResult getResult() {
        if (!isComplete()) {
            throw new IllegalStateException("결과가 나오지 않은 게임입니다.");
        }

        return new RacingGameResult(getCars());
    }

    @Override
    public String visualize() {
        return getVisualGameStatus();
    }

    private String getVisualGameStatus() {
        final StringBuilder visualBuilder = new StringBuilder();
        for (final Car car : getCars()) {
            visualBuilder.append(car.visualize())
                    .append(StringUtils.NEW_LINE);
        }

        return visualBuilder.toString();
    }

    private List<Car> getCars() {
        return option.getCars();
    }

    private void moveAllCar() {
        getCars().forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.moveForward(RandomUtils.getIntWithBound(MOVING_RANDOM_BOUND));
    }
}
