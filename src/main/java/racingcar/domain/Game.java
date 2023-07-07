package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Cars cars;
    private TryCount tryCount;

    public Game(List<String> carNames, TryCount tryCount) {
        this.cars = new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
        this.tryCount = tryCount;
    }

    public List<List<CarStatus>> run() {
        List<List<CarStatus>> gameStatus = new ArrayList<>();
        while (tryCount.isNotZero()) {
            cars.moveAll();
            gameStatus.add(getCarStatuses());
            tryCount = tryCount.minus();
        }
        return gameStatus;
    }

    public List<CarName> findWinnerNames() {
        return cars.findWinnerNames();

    }

    public List<CarStatus> getCarStatuses() {
        return cars.mapToStatus();
    }
}
