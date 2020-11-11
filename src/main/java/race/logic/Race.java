package race.logic;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(EngineFactory factory, List<String> carNames) {
        cars = carNames.stream()
                .map(name -> new Car(factory.createEngine(), name))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void lap() {
        cars.forEach(Car::run);
    }

    public List<Car> getFrontLine() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
