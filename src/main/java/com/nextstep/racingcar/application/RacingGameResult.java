package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.List;

public class RacingGameResult {
    List<RoundResult> roundResults;

    private RacingGameResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public static RacingGameResult create(List<RoundResult> roundResults) {
        return new RacingGameResult(roundResults);
    }
}
