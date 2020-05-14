package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<RoundResult> roundResultList;

    private RacingGameResult(List<RoundResult> roundResultList) {
        this.roundResultList = roundResultList;
    }

    public static RacingGameResult create(List<RoundResult> roundResultList) {
        List<RoundResult> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(roundResultList));
        return new RacingGameResult(unmodifiableList);
    }

    public int size() {
        return this.roundResultList.size();
    }

    public List<RoundResult> getRoundResults() {
        return new ArrayList<>(this.roundResultList);
    }
}
