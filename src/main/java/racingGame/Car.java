package racingGame;

import java.util.Random;

public class Car {

    private static final int FORWARD_LIMIT = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static Random random = new Random();
    private int runDistance = 0;
    private String carName;

    private Car(Builder carBuilder) {
        this.carName = carBuilder.carName;
    }

    public void run() {
        if (randomRangeValue() >= FORWARD_LIMIT) {

    private static Random random = new Random();
    private int runDistance = 0;

    public void run() {
        int forward = 0;
        forward = random.nextInt();

        if (forward >= 4) {
            runDistance++;
        }
    }

    private int randomRangeValue() {
        return random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public String toString() {
        return this.carName + ": " + printDistance();
    }

    private String printDistance() {
        String distance = "";
        for (int i = 0; i < this.runDistance; i++) {
            distance += "-";
        }
        return distance;
    }

    // Builder Class
    public static class Builder {
        private String carName;

        public Builder carName(String carName) {
            this.carName = carName;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
          
    public int getRunDistance() {
        return runDistance;
    }
}
