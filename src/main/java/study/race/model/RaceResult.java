package study.race.model;

import study.race.model.Car;
import study.race.model.Cars;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceResult {

    private int numberOfCar;
    private int maxDistance;
    private Map<String, Integer> racingResult;
    private Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
        this.numberOfCar = cars.carList().size();
        this.maxDistance = 0;
        this.racingResult = new LinkedHashMap<>();
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

    public Winners findWinners() {
        int maxDistance = findMaxDistance();
        Winners winners = findWinners(maxDistance);
        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Map.Entry<String, Integer> result : this.racingResult.entrySet()) {
            maxDistance = getMaxDistance(maxDistance, result.getValue());
        }
        return maxDistance;
    }

    private int getMaxDistance(int maxDistance, int distance) {
        if (maxDistance < distance) {
            return distance;
        }
        return maxDistance;
    }

    private Winners findWinners(int maxDistance) {
        Winners winners = new Winners(maxDistance);
        for (Map.Entry<String, Integer> result : this.racingResult.entrySet()) {
            String carName = result.getKey();
            int distance = result.getValue();
            winners.addWinners(carName, distance);
        }
        return winners;
    }
}
