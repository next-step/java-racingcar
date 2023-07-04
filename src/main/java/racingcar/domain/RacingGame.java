package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {

    private final Car[] cars;

    public RacingGame(Car... cars) {
        Set<String> duplicatedNameCars = new HashSet<>();
        for(Car car : cars) {
            if(duplicatedNameCars.contains(car.getName())) {
                throw new IllegalArgumentException("");
            }
            duplicatedNameCars.add(car.getName());
        }
        this.cars = cars;
    }

}
