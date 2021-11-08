package racingcar.collection;


import racingcar.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceResult {
    private final Map<Car, Integer> racingResults = new HashMap<>();

    public List<Car> getCars() {
        return new ArrayList<>(racingResults.keySet());
    }

    public void addResult(Car car) {
        racingResults.put(car,
                car.getCurrentPosition()
                .getPosition());
    }

    public Integer getCarPositionResult(Car car) {
        return racingResults.get(car);
    }
}
