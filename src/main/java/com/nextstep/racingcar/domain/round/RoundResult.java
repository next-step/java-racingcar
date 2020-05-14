package com.nextstep.racingcar.domain.round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {
    private final List<CarRoundResult> values;

    private RoundResult(List<CarRoundResult> carRoundResultList) {
        this.values = carRoundResultList;
    }

    public static RoundResult create(List<CarRoundResult> carRoundResultList) {
        List<CarRoundResult> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(carRoundResultList));
        return new RoundResult(unmodifiableList);
    }

    public int size() {
        return this.values.size();
    }

    public List<CarRoundResult> getValues() {
        return Collections.unmodifiableList(new ArrayList<>(values));
    }
}
