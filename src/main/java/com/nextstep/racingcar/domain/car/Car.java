package com.nextstep.racingcar.domain.car;

public class Car {
    private MoveLength moveLength;

    private Car(MoveLength moveLength) {
        this.moveLength = moveLength;
    }

    public Car() {
        this(MoveLength.createZero());
    }

    public MoveLength getMoveLength() {
        return this.moveLength;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMoveable(Power.generate())) {
            this.moveLength = this.moveLength.increase();
        }
    }
}
