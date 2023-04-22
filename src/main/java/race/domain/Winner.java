package race.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public List<String> get(List<Car> racingCars) {
        List<Car> sortedCars = getSortedCars(racingCars);
        return getWinnersList(sortedCars);
    }

    private List<String> getWinnersList(List<Car> sortedCars) {
        List<String> winners = new ArrayList<>();

        int maxDistance = sortedCars.get(0).getMovingDistance();
        sortedCars.stream()
            .filter(car -> car.isWinner(maxDistance))
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
