package racingcar.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final List<Car> cars = new ArrayList<>();
    private Map<Car, Integer> currentSituation = new HashMap<>();
    private int countOfMovesAttemps = 0;

    public void initialize(int countOfCars, int countOfMovesAttemps) {
        registerCarsToParticipateInRace(countOfCars);
        updateCurrentSituation();
        setCountOfMovesAttemps(countOfMovesAttemps);
    }

    private void registerCarsToParticipateInRace(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.of(CarName.get(i)));
        }
    }

    private void updateCurrentSituation() {
        for (Car car : cars) {
            this.currentSituation.put(car, car.getTotalDistance());
        }
    }

    private void setCountOfMovesAttemps(int countOfMovesAttemps) {
        this.countOfMovesAttemps = countOfMovesAttemps;
    }

    public Map<Car, Integer> getCurrentSituation() {
        return this.currentSituation;
    }



}
