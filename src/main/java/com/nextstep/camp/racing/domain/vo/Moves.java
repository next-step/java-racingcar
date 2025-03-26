package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Moves {

    private final List<Move> values;
    private Position position = Position.of(PositiveInteger.of(0));

    private Moves() {
        this.values = new ArrayList<>();
    }

    private Moves(List<Move> values) {
        this.values = new ArrayList<>(values);
    }

    public static Moves initialize() {
        return new Moves();
    }

    public static Moves of(List<Move> values) {
        return new Moves(values);
    }

    public void move() {
        Move move = Move.decideBy(RandomMoveStrategy.INSTANCE);
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

    public Moves append(Move move) {
        List<Move> newValues = new ArrayList<>(values);
        newValues.add(move);
        return new Moves(newValues);
    }
}
