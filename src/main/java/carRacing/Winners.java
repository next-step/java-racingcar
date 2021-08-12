package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String toStringWinners() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    }

    public boolean contains(Car car) {
        return winners.contains(car);
    }
}
