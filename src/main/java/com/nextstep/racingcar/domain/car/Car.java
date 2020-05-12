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

    public void move(Power power) {
        MoveStartegy moveStartegy = new PowerOverFourStrategy();
        if(moveStartegy.isMoveable(power)) {
            this.moveLength = this.moveLength.increase();
        }
    }
}
