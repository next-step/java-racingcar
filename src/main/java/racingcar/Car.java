package racingcar;


import java.util.Random;

public class Car {

    private String status = "";

    private static final int MINIMUM_VALUE = 4;
    private Random random;

    public Car(Random random) {
        this.random = random;
    }

    public String getStatus() {
        return this.status;
    }

    public void run() {
        if (!checkGreaterThanOrEqualToMinimumValue(generateRandomNumber())) {
            return;
        }
        this.status += "-";
    }

    public int generateRandomNumber() {
        return random.nextInt(10);
    }

    public boolean checkGreaterThanOrEqualToMinimumValue(int number) {
        return number >= MINIMUM_VALUE;
    }
}
