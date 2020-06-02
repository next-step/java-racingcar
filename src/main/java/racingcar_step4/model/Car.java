package racingcar_step4.model;

import java.util.Random;

public class Car implements Comparable<Car>{

    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_POSSIBLE_VALUE = 4;
    private static final int FORWARD_VALUE = 1;

    private String carName;
    private int totalDistance;

    public Car() {
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int totalDistance) {
        this.carName = carName;
        this.totalDistance = totalDistance;
    }

    public int move() {
        int randomNumber = getRandom();
        if(randomNumber >= MOVE_POSSIBLE_VALUE) {
            return totalDistance += FORWARD_VALUE;
        }
        return totalDistance;
    }

    private int getRandom() {
        Random rand = new Random();
        return rand.nextInt(RANDOM_RANGE);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return this.totalDistance - car.totalDistance;
    }
}
