package com.nextstep.camp.racing.domain.vo;

import java.util.List;

public class Car {

    private Moves moves = Moves.initialize();

    private Car() {
    }

    public static Car of() {
        return new Car();
    }

    public void move() {
        this.moves.move();
    }

    public Position getPosition() {
        return moves.getPosition();
    }
}
