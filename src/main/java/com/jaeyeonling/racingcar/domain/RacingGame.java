package com.jaeyeonling.racingcar.domain;

public class RacingGame {

    static final int MOVING_RANDOM_BOUND = 9;

    private final Participants participants;
    private int movingCount;

    public RacingGame(final RacingGameOption option) {
        this.participants = option.getParticipants();
        this.movingCount = option.getMovingCount();
    }

    public void move() {
        if (isComplete()) {
            throw new IllegalStateException("이미 결과가 나온 게임입니다.");
        }

        participants.move();
        movingCount--;
    }

    public boolean isComplete() {
        return Car.DEFAULT_POSITION == movingCount;
    }

    public RacingGameResult getResult() {
        if (!isComplete()) {
            throw new IllegalStateException("결과가 나오지 않은 게임입니다.");
        }

        return new RacingGameResult(participants);
    }

    public Participants getParticipants() {
        return participants;
    }
}
