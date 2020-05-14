package com.nextstep.racingcar.domain.round;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundResult that = (RoundResult) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    public String toStringResult() {
        return this.values.stream()
                .map(carRoundResult -> carRoundResult.toStringStatus() + "\n")
                .collect(Collectors.joining());
    }
}
