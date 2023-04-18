package race;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public Cars startLap() {
        cars.moveAll();
        return cars;
    }

    public List<CarName> winner() {
        int topScore = cars.getCarList()
                .stream()
                .mapToInt(it -> it.getPosition().get())
                .max()
                .getAsInt();

        return cars.getCarList()
                .stream()
                .filter(it -> it.getPosition().equals(topScore))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
