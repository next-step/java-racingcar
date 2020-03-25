package racinggame.domain.racing;

import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {
    private List<Car> result = new ArrayList<>();

    public RoundResult(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            result.add(new Car(car.getCarName(), car.getMoveRange()));
        }
    }

    public List<Car> getResult() {
        return result;
    }
}
