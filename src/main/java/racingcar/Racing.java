package racingcar;

import java.util.*;

public class Racing {

    private final int gameCount;
    private final List<Car> cars;
    private final List<List<Integer>> raceRecord;
    private final RacingRandom racingRandom = RacingRandom.getInstance();

    public Racing(int carsNum, int gameCount) {
        this.gameCount = gameCount;
        this.cars = createCars(carsNum);
        this.raceRecord = new ArrayList<>();
    }

    private List<Car> createCars(int carsNum) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < carsNum; i++) {
            result.add(new Car());
        }
        return result;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void race() {
        for (int i = 0; i < gameCount; i++) {
            game();
            record();
        }
    }

    private void record() {
        List<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getDistance());
        }
        raceRecord.add(result);
    }

    private void game() {
        for (Car car : cars) {
            move(car);
        }
    }

    private void move(Car car) {
        if (car.moveable(racingRandom.getNumber())) {
            car.move();
        }
    }


    public List<List<Integer>> getRaceRecord() {
        return raceRecord;
    }
}
