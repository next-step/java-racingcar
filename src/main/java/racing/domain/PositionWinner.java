package racing.domain;

import racing.dto.RaceWinnerResult;

import java.util.List;
import java.util.stream.Collectors;

public class PositionWinner implements RaceWinner {

    @Override
    public RaceWinnerResult calculateWinners(List<Car> cars) {
        int maxPosition = this.calculateMaxPosition(cars);
        return new RaceWinnerResult(
                cars.stream()
                        .filter(car -> car.findCurrentPosition() == maxPosition)
                        .map(car -> car.getName())
                        .collect(Collectors.toList())
        );
    }

    private int calculateMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::findCurrentPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
