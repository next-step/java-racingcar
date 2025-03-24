package com.nextstep.camp.racing.infrastructure.view;

import com.nextstep.camp.racing.infrastructure.view.component.RacingResult;

import java.util.List;

public class RacingResultView {
    private final RacingResult racingResult;

    private RacingResultView(RacingResult racingResult) {
        this.racingResult = racingResult;
    }

    public static RacingResultView publish(RacingResult racingResult) {
        return new RacingResultView(racingResult);
    }

    public void render() {
        racingResult.action();
    }
}
