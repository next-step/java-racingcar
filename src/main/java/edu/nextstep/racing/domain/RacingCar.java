package edu.nextstep.racing.domain;

public class RacingCar {
    private int carPosition = 0;
    private String carName;

    RacingCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name is too long");
        }
        this.carName = carName;
    }

    void move(MovingCheck movingCheck) {
        if(movingCheck.isMovable()) {
            this.carPosition++;
        }
    }

    int getStatus() {
        return this.carPosition;
    }

    String getCarName() {
        return this.carName;
    }
}
