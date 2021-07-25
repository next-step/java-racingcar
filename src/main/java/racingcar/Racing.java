package racingcar;

import java.util.ArrayList;

public class Racing {

    private final int BOUND_RANDOM_NUMBER = 10;
    private final int MORE_THEN_STANDARD_NUMBER = 4;

    private Car[] racingCars;
    private ArrayList<ArrayList<RacingRecord>> racingHistory = new ArrayList<>();

    public Racing() {
        this(10);
    }

    public Racing(int carCount) {
        racingCars = new Car[carCount];
        addCars();
    }

    private void addCars() {
        for (int i = 0; i < racingCars.length; i++) {
            Car car = new Car();
            racingCars[i] = car;
        }
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveTryCarsAndHistorySave();
        }
    }

    private void moveTryCarsAndHistorySave() {
        ArrayList<RacingRecord> records = new ArrayList<>();
        for (Car car : racingCars) {
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
        return RandomGenerate.pick(BOUND_RANDOM_NUMBER, MORE_THEN_STANDARD_NUMBER);
    }

    public Car[] getRacingCars() {
        return racingCars;
    }

    public ArrayList<ArrayList<RacingRecord>> getRacingHistory() {
        return racingHistory;
    }
}

