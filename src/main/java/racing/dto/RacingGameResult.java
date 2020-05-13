package racing.dto;

import racing.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private List<Car> cars;
    private int maxPosition;

    public RacingGameResult(List<Car> cars) {
        this.cars = cars;
        this.calculateMaxPosition();
    }

    private void calculateMaxPosition() {
        this.maxPosition = this.cars
                .stream()
                .map(car -> car.findCurrentPosition())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> calculateWinners() {
        List<Car> winners = this.cars.stream()
                .filter(car -> car.findCurrentPosition() == this.maxPosition)
                .collect(Collectors.toList());

        if (winners.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return winners;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
