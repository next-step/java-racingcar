package carracing.domain;

import java.util.Random;

/**
 * Car
 * version 0.0.1
 * 
 * history
 *  0.0.1) 클래스 신규생성
 */
public class Car {

    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int MOVABLE_MAX_NUMBER = 9;

    private static final int MOVE = 1;
    private static final int STOP = 1;

    private final int carNumber;
    private int mileage;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void drive() {
        mileage+=this.move();
    }

    private int move() {
        Random random = new Random();
        return random.nextInt(MOVABLE_MAX_NUMBER)>=MOVABLE_MIN_NUMBER ? MOVE : STOP;
    }
}
