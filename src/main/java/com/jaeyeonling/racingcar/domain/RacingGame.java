package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.RandomUtils;

import java.util.List;

public class RacingGame {

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

    public Participants getParticipants() {
        return option.getParticipants();
    }

    private List<Car> getCars() {
        return getParticipants().getCars();
    }

    private void moveAllCar() {
        getCars().forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.moveForward(RandomUtils.getIntWithBound(MOVING_RANDOM_BOUND));
    }
}
