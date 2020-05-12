package com.nextstep.racingcar.domain.car;

public class RandomMoveCar implements Car {
    private MoveLength moveLength;

    private RandomMoveCar(MoveLength moveLength) {
        this.moveLength = moveLength;
    }

    public RandomMoveCar() {
        this(MoveLength.createZero());
    }

    public MoveLength getMoveLength() {
        return this.moveLength;
    }

    public void move() {
        if(MoveStrategy.isMoveable(Power.generate())) {
            this.moveLength = this.moveLength.increase();
        }
    }
}
