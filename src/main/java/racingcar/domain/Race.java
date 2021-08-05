package racingcar.domain;

import java.util.ArrayList;
public class Race {
    final int MAX_CAR_NUM = 10;

    private ArrayList<Car> cars;

    int carNum = 1;
    int raceNum = 1;
    Race(int carNum, int raceNum) {
        this.carNum = carNum;
        this.raceNum = raceNum;
        checkIfValidArgumentsForRace();

        cars = new ArrayList<>(10);
        for (int i = 0; i < carNum; i++) {
            this.cars.add(new Car());
        }
    }
    Race() {
        this(1, 1);
    }

    private void checkIfValidArgumentsForRace() throws IllegalArgumentException {
        if (carNum == 0 || raceNum == 0)
            throw new IllegalArgumentException("Invalid Arguments for Race");
    }

    int getNumberOfCars() {
        return cars.size();
    }
}
