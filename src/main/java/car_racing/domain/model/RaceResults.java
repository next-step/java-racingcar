package car_racing.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResults {
    private final List<Car> cars;

    public RaceResults(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getRaceResultOfNthRound(int round) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getRaceResultOfRound(round));
        }
        return result;
    }

    public List<Car> getWinners() {
        if (cars.isEmpty()) return Collections.emptyList();

        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

}
