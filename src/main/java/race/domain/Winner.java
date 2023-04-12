package race.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<String> winners = new ArrayList<>();

    public List<String> get(List<Car> racingCars) {
        List<Car> sortedCars = getSortedCars(racingCars);
        return getWinners(sortedCars);
    }

    private List<String> getWinners(List<Car> sortedCars) {
        int maxDistance = sortedCars.get(0).getMovingDistance();
        sortedCars.stream()
            .filter(car -> car.getMovingDistance() == maxDistance)
            .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private List<Car> getSortedCars(List<Car> racingCars) {
        return racingCars.stream()
            .sorted(
                (car1, car2) -> Integer.compare(car2.getMovingDistance(), car1.getMovingDistance())
            ).collect(Collectors.toList());
    }
}
