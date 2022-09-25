package step3.domain;

import java.util.Random;

public class Car {

    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;

    private int currentStatus;


    public Car() {
    }

    public Car returnCar() {
        int randomNum = generateRandomNum();
        if (isMovingForward(randomNum)) {
            this.currentStatus += 1;
        }
        return this;
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int status) {
        this.currentStatus = status;
    }

}
