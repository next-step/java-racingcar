package com.step3.model.car;

public class CarPosition {
    int carPosition;

    public CarPosition(int _carPosition) {
        this.carPosition = _carPosition;
    }

    public CarPosition add(boolean isMoved) {
        if (isMoved) {
            this.carPosition += 1;
        }
        return this;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
