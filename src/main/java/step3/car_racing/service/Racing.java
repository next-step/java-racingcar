package step3.car_racing.service;

import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Cars> raceResult = new ArrayList<>();

    public Racing(int racingSize, Cars cars) {
        for (int i = 0; i < racingSize; i++) {
            List<Car> carList = cars.move();
            this.raceResult.add(new Cars().resultCars(carList));
        }
    }

    public List<Cars> getRaceResult() {
        return this.raceResult;
    }

    public Cars getFinalRace() {
        return this.raceResult.get(this.raceResult.size() - 1);
    }
}
