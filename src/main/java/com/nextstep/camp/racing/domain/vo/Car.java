package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class Car {

    private final Moves moves = Moves.initialize();

    private Car() {
    }

    public static Car of() {
        return new Car();
    }

    public void move() {
        this.moves.move();
    }

    public PositiveInteger getPosition() {
        return moves.getPosition();
    }

    public Moves getMoves() {
        return moves;
    }
}
