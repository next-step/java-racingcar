package step3;

import java.util.Random;

public class Car {

    private static final int MAX_MOVE = 10;
    private static final Random RANDOM = new Random();
    private final int carNumber;
    private int location;

    public Car(int carNumber) {
        if (carNumber < 1) {
            throw new RuntimeException("차 번호가 자연수가 아닙니다.");
        }
        this.carNumber = carNumber;
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void goRandomDistance() {
        int distance = RANDOM.nextInt(MAX_MOVE);
        if (distance >= 4) {
            location += distance;
        }
    }
}
