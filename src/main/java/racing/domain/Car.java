package racing.domain;

import java.util.Random;

public class Car implements Comparable<Car> {

    private final int LIMIT_VALUE = 4;

    private final int RANDOM_VALUE = 10;

    private final int MOVE_VALUE = 1;

    private String name;

    private Integer totalDistance = 0;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int move() {
        int randomValue = getRandomValue();
        if (getMoveCount(randomValue)) {
            totalDistance += MOVE_VALUE;
        }

        return totalDistance;
    }

    public boolean getMoveCount(int randomValue) {
        return randomValue >= LIMIT_VALUE;

    }

    public int getRandomValue() {
        return new Random().nextInt(RANDOM_VALUE);
    }

    public String getName() {
        return name;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return totalDistance.compareTo(car.totalDistance);
    }
}
