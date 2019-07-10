package homework.week1.racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameResult {
    private final List<Car> resultCars;

    private GameResult(List<Car> resultCars) {
        this.resultCars = resultCars;
    }

    public static GameResult of(List<Car> resultCars) {
        return new GameResult(resultCars);
    }

    public int getMaxPosition() {
        Collections.sort(resultCars);
        return resultCars.stream()
                .findFirst()
                .orElse(new Car("none"))
                .getPosition();
    }

    public List<String> getWinnerNames(int maxPosition) {
        return resultCars.stream()
                .filter(t -> t.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getResultCars() {
        return Collections.unmodifiableList(resultCars);
    }

}
