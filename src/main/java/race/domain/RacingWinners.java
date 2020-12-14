package race.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingWinners {
    private static final String DELIMITER = ", ";

    private final List<Car> cars;

    public RacingWinners(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isWinners(List<Car> cars) {
        if (this.cars.size() != cars.size()) {
            return false;
        }
        return IntStream.range(0, this.cars.size())
                .allMatch(index -> this.cars.get(index).equals(cars.get(index)));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER)) + "가 최종 우승했습니다.";
    }
}
