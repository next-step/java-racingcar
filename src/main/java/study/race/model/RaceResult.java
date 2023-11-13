package study.race.model;

import study.race.model.Car;
import study.race.model.Cars;

public class RaceResult {

    private int numberOfCar;
    private int[] racingResult;
    private Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
        this.numberOfCar = cars.carList().size();
        racingResult = new int[this.numberOfCar];
        this.updateRaceResult();
    }

    public int[] getResult() {
        return this.racingResult;
    }

    public void updateRaceResult() {
        for (int i = 0; i < this.numberOfCar; i++) {
            Car car = cars.carList().get(i);
            racingResult[i] = car.getCurrentLocation();
        }
    }
}
