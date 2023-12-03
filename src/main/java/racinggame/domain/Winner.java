package racinggame.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getWinners() {
        return getWinnerByPosition(getWinnerPosition());
    }

    private List<String> getWinnerByPosition(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() > 0 && car.getPosition() == winnerPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }
}
