package com.nextstep.camp.racing.domain.vo;

import java.util.ArrayList;
import java.util.List;

public class Lap {
    private final List<Moves> allMoves;

    public Lap(List<Moves> allMoves) {
        this.allMoves = List.copyOf(allMoves);
    }

    public List<Moves> getAllMoves() {
        return allMoves;
    }
}
