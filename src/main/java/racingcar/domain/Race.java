package racingcar.domain;

import java.util.ArrayList;
public class Race {
    final int MAX_CAR_NUM = 10;

    private ArrayList<Car> cars;

    int carNum = 1;
    int roundNum = 1;
    Race(int carNum, int roundNum) {
        this.carNum = carNum;
        this.roundNum = roundNum;
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
        if (carNum == 0 || roundNum == 0)
            throw new IllegalArgumentException("Invalid Arguments for Race");
    }

    int getNumberOfCars() {
        return cars.size();
    }

    void runRace() {
        
    }
}
