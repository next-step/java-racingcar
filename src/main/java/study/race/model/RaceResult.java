package study.race.model;

import study.race.model.Car;
import study.race.model.Cars;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceResult {

    private int numberOfCar;
    private int maxDistance;
    private String[] winners;
    private Map<String, Integer> racingResult;
    private Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
        this.numberOfCar = cars.carList().size();
        this.maxDistance = 0;
        racingResult = new LinkedHashMap<>();
        this.updateRaceResult();
    }

    public void updateRaceResult() {
        for (int i = 0; i < this.numberOfCar; i++) {
            Car car = cars.carList().get(i);
            racingResult.put(car.getName(), car.getCurrentLocation());
        }
    }

    public Map<String, Integer> getResult() {
        return this.racingResult;
    }


}
