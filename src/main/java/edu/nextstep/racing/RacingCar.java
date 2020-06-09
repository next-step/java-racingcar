package edu.nextstep.racing;

public class RacingCar {
    private int carPosition = 0;
    private String carName;

    RacingCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name is too long");
        }
        this.carName = carName;
    }

    public void move(MovingCheck movingCheck) {
        if(movingCheck.isMovable()) {
            this.carPosition++;
        }
    }

    public int getStatus() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }
}
