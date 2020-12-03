package com.nextstep.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private final List<Integer> values;

    public MoveResult(final List<Integer> values) {
        this.values = new ArrayList<>(values);
    }
}
