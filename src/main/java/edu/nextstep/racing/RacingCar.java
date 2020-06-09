package edu.nextstep.racing;

public class RacingCar {
    private int carPosition = 0;

    public void move(MovingCheck movingCheck) {
        if(movingCheck.isMovable()) {
            this.carPosition++;
        }
    }

    public int getStatus() {
        return this.carPosition;
    }
}
