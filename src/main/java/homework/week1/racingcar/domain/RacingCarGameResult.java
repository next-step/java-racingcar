package homework.week1.racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameResult {
    private final List<Car> resultCars;

    private RacingCarGameResult(List<Car> resultCars) {
        this.resultCars = resultCars;
    }

    public static RacingCarGameResult of(List<Car> resultCars) {
        return new RacingCarGameResult(resultCars);
    }

    public int getMaxPosition() {
        return resultCars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0)
                .intValue();
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
