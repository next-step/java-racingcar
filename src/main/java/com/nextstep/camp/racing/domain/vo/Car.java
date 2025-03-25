package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class Car {

    private final CarName name;
    private boolean isWinner = false;

    private final Moves moves = Moves.initialize();

    private Car(CarName name) {
        this.name = name;
    }

    public static Car of(CarName name) {
        return new Car(name);
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

    public CarName getName() {
        return name;
    }

    public void win() {
        isWinner = true;
    }

    public boolean isWinner() {
        return isWinner;
    }
}
