package racingcar.domain;

import racingcar.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carName){
        this.cars = makeCars(carName);
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::newCar)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByName(List<String> carNames) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.isContained(carNames)) {
                result.add(car);
            }
        }
        return result;
    }

    public void tryToMove(int randomNumber) {
        cars.forEach(c -> c.tryToMove(randomNumber));
    }

    public RaceRecord saveRecord(int round) {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            car.saveLocation(map);
        }
        return new RaceRecord(round, map);
    }
}
