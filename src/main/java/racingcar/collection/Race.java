package racingcar.collection;


import racingcar.Car;

import java.util.*;

public class Race {
    private final Map<Car, Integer> racingResults = new LinkedHashMap<>();

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
