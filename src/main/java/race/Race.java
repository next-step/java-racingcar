package race;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public List<CarView> startLap() {
        cars.moveAll();
        return cars.getCarList()
                .stream()
                .map(it -> new CarView(
                                it.getCarName().getCarName(),
                                it.getPosition().getPosition()
                        )
                ).collect(Collectors.toList());
    }

    public List<CarView> getWinners() {
        int topScore = cars.getCarList()
                .stream()
                .map(Car::getPosition)
                .max(Position.getComparator())
                .get()
                .getPosition();

        return cars.getCarList()
                .stream()
                .filter(it -> it.getPosition().equals(topScore))
                .map(it -> new CarView(
                                it.getCarName().getCarName(),
                                it.getPosition().getPosition()
                        )
                ).collect(Collectors.toList());
    }
}
