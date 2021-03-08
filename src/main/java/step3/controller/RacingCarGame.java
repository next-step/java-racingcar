package step3.controller;

import step3.domain.Car;
import java.util.*;

public class RacingCarGame {

    private static final int RANDOM_SCOPE = 10;
    private final Random random = new Random();
    private int totalCar;
    private int attemptCount;

    public RacingCarGame (int totalCar, int attemptCount) {
        this.attemptCount = attemptCount;
        this.totalCar = totalCar;
    }

    public int carAdvanced() {
        Car car = new Car();
        for (int i = 0; i < this.attemptCount; i++) {
            car.move(random.nextInt(RANDOM_SCOPE));
        }

        return car.getAdvance();
    }

    public List<Integer> eachCarList() {
        List<Integer> attemptList = new ArrayList<>();
        for (int i = 0; i < totalCar; i++) {
            attemptList.add(carAdvanced());
        }
        return attemptList;
    }

    public List<List<Integer>> eachAttemptCarList() {
        List<List<Integer>> eachList = new ArrayList<>();
        for(int i = 0; i < attemptCount; i++) {
            eachList.add(eachCarList());
        }
        return eachList;
    }
}
