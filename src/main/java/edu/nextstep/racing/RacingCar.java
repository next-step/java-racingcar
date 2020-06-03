package edu.nextstep.racing;

public class RacingCar {
    RandomNumber randomNumber = null;
    int carPosition = 0;

    RacingCar() {
        randomNumber = new RandomNumber();
    }

    public void move() {
        int randomNum = randomNumber.generator();
        if(randomNum >= 4) {
            this.carPosition++;
        }
    }

    public int getStatus() {
        return this.carPosition;
    }
}
