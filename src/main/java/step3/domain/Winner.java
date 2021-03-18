package step3.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {
    private final Cars cars;

    public Winner(Cars cars) {
        this.cars = cars;
    }

    public List<String> findWinnerCarNames() {
        int position = getMaxCurrentPosition();
        return cars.getCars()
                .stream()
                .filter(car -> car.isWinner(position))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxCurrentPosition() {
        return cars.getCars()
                .stream()
                .max(Comparator.comparingInt(Car::getCurrentPosition))
                .orElseThrow(NoSuchElementException::new)
                .getCurrentPosition();
    }
}
