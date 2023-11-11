package step3.domain;

import java.util.Comparator;
import java.util.List;

public class RaceWinner {
    
    public List<String> getWinners(Cars cars) {
        return winnerNames(cars.getCars(), maxPosition(cars.getCars()));
    }

    private List<String> winnerNames(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(java.util.stream.Collectors.toList());
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream().max(Comparator.comparing(Car::position)).get().position();
    }


}
