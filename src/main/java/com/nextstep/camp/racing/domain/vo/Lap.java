package com.nextstep.camp.racing.domain.vo;

import java.util.List;

public class Lap {
    private final List<CarMoves> values;

    public Lap(List<CarMoves> values) {
        this.values = List.copyOf(values);
    }

    public List<CarMoves> getAllMoves() {
        return values;
    }
}
