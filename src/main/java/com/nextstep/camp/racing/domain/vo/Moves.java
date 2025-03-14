package com.nextstep.camp.racing.domain.vo;

import java.util.ArrayList;
import java.util.List;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class Moves {

    private final List<Move> values;

    private Moves() {
        this.values = new ArrayList<>();
    }

    private Moves(List<Move> values) {
        this.values = values;
    }

    public static Moves initialize() {
        return new Moves();
    }

    public static Moves of(List<Move> values) {
        return new Moves(values);
    }

    public void move() {
        this.values.add(Move.decide());
    }

    public Position getPosition() {
        long count = values.stream()
            .filter(Move::isMove)
            .count();
        PositiveInteger position = PositiveInteger.of(count);
        return Position.of(position);
    }
}
