package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class Winner {

    public List<Car> getWinners(List<Car> cars) {
        return getEntrySet(cars)
                .stream().max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }

    private Set<Map.Entry<Integer, List<Car>>> getEntrySet(List<Car> cars) {
        return cars.stream()
                .collect(groupingBy(Car::getDistance))
                .entrySet();
    }
}