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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceWinner that = (RaceWinner) o;

        return winners != null ? winners.equals(that.winners) : that.winners == null;
    }

    @Override
    public int hashCode() {
        return winners != null ? winners.hashCode() : 0;
    }
}
