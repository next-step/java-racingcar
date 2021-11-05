package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int countOfCar) {
        for(int i=0; i<countOfCar; i++) {
            cars.add(new Car());
        }
    }

    public List<Integer> race() {
        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }
}
