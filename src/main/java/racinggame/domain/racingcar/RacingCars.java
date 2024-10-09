package racinggame.domain.racingcar;

import racinggame.domain.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    private RacingCars(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static RacingCars create(MoveStrategy moveStrategy, List<String> nameList) {
        return nameList.stream()
                .map(name -> RacingCar.create(moveStrategy, name))
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public int count() {
        return cars.size();
    }

    public void moveAll() {
        cars.forEach(RacingCar::move);
    }

    public Map<String, Integer> getCarsInfo() {
        Map<String, Integer> carInfo = new LinkedHashMap<>();
        for (RacingCar car : cars) {
            carInfo.put(car.getCarName(), car.getCurrentPosition());
        }
        return carInfo;
    }
}
