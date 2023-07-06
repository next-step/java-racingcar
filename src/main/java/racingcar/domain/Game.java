package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Cars cars;
    private final TryCount tryCount;

    public Game(List<CarName> carNames, TryCount tryCount) {
        this.cars = new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
        this.tryCount = tryCount;
    }

    public List<List<CarStatus>> run() {
        List<List<CarStatus>> gameStatus = new ArrayList<>();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.moveAll();
            gameStatus.add(cars.mapToStatus());
        }
        return gameStatus;
    }

    public List<CarName> findWinnerNames() {
        return cars.findWinnerNames();

    }

    public Cars getCars() {
        return cars;
    }
}
