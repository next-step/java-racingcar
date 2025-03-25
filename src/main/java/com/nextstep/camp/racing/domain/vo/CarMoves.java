package com.nextstep.camp.racing.domain.vo;

public class CarMoves {

    private final Car car;
    private final Moves moves;

    public CarMoves(Car car, Moves moves) {
        this.car = car;
        this.moves = moves;
    }

    public static CarMoves of(Car car, Moves moves) {
        return new CarMoves(car, moves);
    }

    public Car getCar() {
        return car;
    }

    public Moves getMoves() {
        return moves;
    }
}
