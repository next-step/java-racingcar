package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResults {
    private final List<RoundResult> values;

    private RoundResults(List<RoundResult> roundResultList) {
        this.values = roundResultList;
    }

    public static RoundResults create(List<RoundResult> roundResultList) {
        List<RoundResult> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(roundResultList));
        return new RoundResults(unmodifiableList);
    }

    public int size() {
        return this.values.size();
    }

    public List<RoundResult> getValues() {
        return Collections.unmodifiableList(new ArrayList<>(values));
    }
}
