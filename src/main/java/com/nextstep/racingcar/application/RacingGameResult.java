package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<RoundResult> roundResults;

    private RacingGameResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public static RacingGameResult create(List<RoundResult> roundResults) {
        List<RoundResult> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(roundResults));
        return new RacingGameResult(unmodifiableList);
    }

    public int size() {
        return this.roundResults.size();
    }

    public List<RoundResult> getRoundResults() {
        return new ArrayList<>(this.roundResults);
    }
}
