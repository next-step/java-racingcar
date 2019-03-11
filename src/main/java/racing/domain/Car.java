package racing.domain;

import java.util.Random;

public class Car implements Comparable<Car> {

    private final int LIMIT_VALUE = 4;

    private String name;

    private Integer totalDistance = 0;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomValue = getRandomValue();
        int moveDistance = getMoveCount(randomValue);
        if (moveDistance == 1) {
            totalDistance += moveDistance;
        }
    }

    public int getMoveCount(int randomValue) {
        if (randomValue >= LIMIT_VALUE) {
            return 1;
        }

        return 0;
    }

    public int getRandomValue() {
        return new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return totalDistance.compareTo(car.getTotalDistance());
    }
}
