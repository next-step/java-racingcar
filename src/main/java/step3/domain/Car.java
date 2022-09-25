package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;

    private int cars;
    private int attempts;

    public Car() {
    }

    public List<Integer> renewedCarList() {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public boolean isAddMoveCount() {
        int randomNum = generateRandomNum();
        return isMovingForward(randomNum);
    }

    public int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    public boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public int getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
