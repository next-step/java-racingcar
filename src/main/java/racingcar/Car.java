package racingcar;

import java.util.Random;

public class Car {
    private int carNumber;
    private int position;

    private final int STANDARD_NUMBER = 4;
    public static Random random = new Random();

    public Car(int carNumber) {
        new Car(carNumber, 0);
    }

    private Car(int carNumber, int position) {
        this.carNumber = carNumber;
        this.position = position;
    }

    public void moveOrStop() {
        if (randomNumberExtraction() >= STANDARD_NUMBER) {
            increasePosition();
        }
    }

    private void increasePosition() {
        position++;
    }

    public static int randomNumberExtraction() {
        return random.nextInt(10);
    }

    public int getPosition() {
        return position;
    }

    public int getCarNumber() {
        return carNumber;
    }
}

