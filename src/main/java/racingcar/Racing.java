package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Racing {

    private final int BOUND_RANDOM_NUMBER = 10;
    private final int MORE_THEN_NUMBER = 4;

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<ArrayList<RacingRecord>> racingHistory = new ArrayList<>();

    public Racing() {
        this(10);
    }

    public Racing(int carCount) {
        for (int i = 0; i < carCount; i++) {
            addCar();
        }
    }

    private void addCar() {
        Car car = new Car();
        cars.add(car);
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveTryCarsAndHistorySave();
        }
    }

    private void moveTryCarsAndHistorySave() {
        ArrayList<RacingRecord> records = new ArrayList<>();
        for (Car car : cars) {
            moveTryCar(car);
            records.add(new RacingRecord(car, car.getPosition()));
        }
        racingHistory.add(records);
    }

    private void moveTryCar(Car car) {
        if (isMoveAble()) {
            car.move();
        }
    }

    private boolean isMoveAble() {
        return new Random().nextInt(BOUND_RANDOM_NUMBER) >= MORE_THEN_NUMBER;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<ArrayList<RacingRecord>> getRacingHistory() {
        return racingHistory;
    }

}

