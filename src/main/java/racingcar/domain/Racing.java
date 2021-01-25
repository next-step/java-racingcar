package racingcar.domain;

import java.util.List;
import java.util.Random;

public class Racing {
    private static final int MINIMUM_DISTANCE_MOVE = 4;
    private static final int MAXIMUM_DISTANCE_MOVE = 9;

    private final List<Car> cars;
    private final int stages;
    private final Random random;

    public Racing(List<Car> cars, int stages){
        this.cars = cars;
        this.stages = stages;
        this.random = new Random();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        for(Car car : this.cars){
            decideMove(car);
        }
    }

    public void decideMove(Car car) {
        if(getRandomNumber() >= MINIMUM_DISTANCE_MOVE){
            car.moveForward();
        }
    }

    public int getRandomNumber() {
        return this.random.nextInt(MAXIMUM_DISTANCE_MOVE + 1);
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for(Car car : this.cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
