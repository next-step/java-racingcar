package com.nextstep.racingcar.domain.car;

public class Car {
    private String driverName;
    private MoveLength moveLength;

    private Car(String driverName, MoveLength moveLength) {
        this.driverName = driverName;
        this.moveLength = moveLength;
    }

    public Car() {
        this(null, MoveLength.createZero());
    }

    public Car(String driverName) {
        this(driverName, MoveLength.createZero());
    }

    public String getDriverName() {
        return this.driverName;
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
