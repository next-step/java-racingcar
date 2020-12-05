package com.nextstep.racinggame.view;

import com.nextstep.racinggame.view.exceptions.InvalidUserInputException;

public class RacingCountInputView {
    private final int racingCount;

    RacingCountInputView(final int racingCount) {
        validate(racingCount);

        this.racingCount = racingCount;
    }

    void validate(final int racingCount) {
        if (racingCount <= 0) {
            throw new InvalidUserInputException("레이싱 회수는 1이상이어야만 합니다.");
        }
    }

    int getRacingCount() {
        return racingCount;
    }
}
