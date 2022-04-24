package carrace;

import java.util.*;
import java.util.stream.Collectors;

public class RaceWinner {

    private List<Car> winners = new ArrayList<>();

    public void confirmWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
