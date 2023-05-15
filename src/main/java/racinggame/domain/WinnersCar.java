package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersCar {
    private final List<Car> winners;

    public WinnersCar(List<Car> cars) {
        int winnerLocation = getWinnerLocation(cars);
        this.winners = cars.stream()
                .filter(car -> car.isWinner(winnerLocation))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> winners() {
        return winners;
    }

    private int getWinnerLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

}
