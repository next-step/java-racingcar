package racingcar.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final List<Car> cars = new ArrayList<>();
    private Map<Car, Integer> currentSituation = new HashMap<>();

    public void registerCarsToParticipateInRace(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.of(CarName.get(i)));
        }

        updateCurrentSituation();
    }

    public Map<Car, Integer> getCurrentSituation() {
        return this.currentSituation;
    }

    private void updateCurrentSituation() {
        for (Car car : cars) {
            this.currentSituation.put(car, car.getTotalDistance());
        }
    }
}
