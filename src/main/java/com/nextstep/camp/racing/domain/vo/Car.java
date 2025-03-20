package com.nextstep.camp.racing.domain.vo;

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

    public Position getPosition() {
        return moves.getPosition();
    }

    public Moves getMoves() {
        return moves;
    }
}
