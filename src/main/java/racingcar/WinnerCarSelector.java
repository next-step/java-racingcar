package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCarSelector {

    public List<Car> getWinnerCars(List<Car> candidateCars) {
        int maxPosition = getMaxPosition(candidateCars);
        return candidateCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }
}
