package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> getWinnerNames() {
        int winnerPosition = getHighPosition();
        return cars.stream()
                .filter(c -> c.isWinner(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getTotalStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    private int getHighPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.DEFAULT_POSITION);
    }
}
