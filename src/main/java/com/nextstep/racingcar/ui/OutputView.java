package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.application.RacingGameResult;

import java.util.stream.Collectors;

public class OutputView {
    private RacingGameResult racingGameResult;

    public OutputView(RacingGameResult racingGameResult) {
        this.racingGameResult = racingGameResult;
    }

    public String toStringResult() {
        return racingGameResult.getRoundResults().stream()
                .map(roundResult -> roundResult.toStringResult() + "\n")
                .collect(Collectors.joining());
    }
}
