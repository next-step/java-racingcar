package com.nextstep.camp.racing.domain.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.strategy.RandomMoveStrategy;

public class Moves {

    private final List<Move> values;
    private Position position = Position.of(PositiveInteger.of(0));

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
        Move move = Move.decide(RandomMoveStrategy.INSTANCE);
        this.values.add(move);
        if (move.isMove()) {
            this.position = this.position.add(1);
        }
    }

    public PositiveInteger getPosition() {
        return position.value();
    }

    public Stream<Move> stream() {
        return values.stream();
    }

    public List<Move> getValues() {
        return values;
    }

    public Move getLast() {
        return values.get(values.size() - 1);
    }

    public Moves append(Move move) {
        List<Move> newValues = new ArrayList<>(values);
        newValues.add(move);
        return new Moves(newValues);
    }
}
