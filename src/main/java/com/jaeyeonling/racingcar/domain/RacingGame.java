package com.jaeyeonling.racingcar.domain;

public class RacingGame {

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

    public RacingGameStatus getStatus() {
        return new RacingGameStatus(this);
    }

    Participants getParticipants() {
        return option.getParticipants();
    }

    private void moveAllCar() {

        for (final Car car : getParticipants().toList()) {
            moveCar(car);
        }
    }

    private void moveCar(final Car car) {
        if (option.getMoveStrategy().isMove()) {
            car.moveForward();
        }
    }
}
