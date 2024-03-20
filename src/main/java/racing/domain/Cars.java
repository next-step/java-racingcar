package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public String getWinner() {
        int maxRunCount = cars.stream()
            .mapToInt(Car::getRunCount)
            .max()
            .orElse(0);

        List<String> winners = cars.stream()
            .filter(car -> car.getRunCount() == maxRunCount)
            .map(car -> car.getName().getName())
            .collect(Collectors.toList());

        return String.join(", ", winners);
    }
}
