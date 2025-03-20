package racing;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Report {

    private final List<Car> cars;
    static final Function<List<Car>, List<String>> findChampions = cars -> {
        var championsScore = cars.stream()
                                 .mapToInt(Car::getPosition)
                                 .max();

        return cars.stream()
                   .filter(car -> car.getPosition() == championsScore.getAsInt())
                   .map(Car::getName)
                   .collect(Collectors.toUnmodifiableList());
    };

    public Report(List<Car> cars) {
        this.cars = cars;
    }

    public Car findCarByIndex(Integer index) {
        if (index < 0 || index >= cars.size()) {
            throw new IllegalArgumentException("Not valid index");
        }

        return cars.get(index);
    }
}
