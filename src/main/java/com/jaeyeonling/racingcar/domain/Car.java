package com.jaeyeonling.racingcar.domain;

class Car {

    static final int DEFAULT_POSITION = 1;

    private int position;
    private MoveStrategy moveStrategy;

    Car(final MoveStrategy moveStrategy) {
        this(DEFAULT_POSITION, moveStrategy);
    }

    Car(final int position, final MoveStrategy moveStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    void moveForward() {
        if (moveStrategy.isMove()) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }

    public CarStatus getStatus() {
        return new CarStatus(this);
    }
}
