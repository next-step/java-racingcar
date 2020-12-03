package com.nextstep.racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CurrentDistance {
    private final List<Integer> values;

    public CurrentDistance(List<Integer> values) {
        this.values = new ArrayList<>(values);
    }

    public List<Integer> getValues() {
        return new ArrayList<>(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentDistance that = (CurrentDistance) o;
        return this.values.equals(that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
