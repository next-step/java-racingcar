package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    List<Integer> carsPositions = new ArrayList<>();

    public RoundResult(List<Car> cars) {
        for (Car car : cars) {
            carsPositions.add(car.getPosition());
        }
    }

    public List<Integer> getCarsPositions() {
        return carsPositions;
    }
}
