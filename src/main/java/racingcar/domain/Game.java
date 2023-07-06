package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Cars cars;

    public Game(List<CarName> carNames) {
        this.cars = new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void run() {
        cars.moveAll();
    }

    public List<CarName> findWinnerNames() {
        return cars.findWinnerNames();

    }

    public Cars getCars() {
        return cars;
    }
}
