package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.exception.CompleteException;
import com.jaeyeonling.racingcar.exception.NotCompleteException;

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
            throw new CompleteException();
        }

        participants.move();
        movingCount--;
    }

    public boolean isComplete() {
        return Car.DEFAULT_POSITION == movingCount;
    }

    public RacingGameResult getResult() {
        if (!isComplete()) {
            throw new NotCompleteException();
        }

        return new RacingGameResult(participants);
    }

    public Participants getParticipants() {
        return participants;
    }
}
