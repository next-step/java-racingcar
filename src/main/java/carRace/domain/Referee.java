package carRace.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<String> findWinners(final List<Car> cars) {
        return findCarNameWithWinningScore(cars, calculateWinningScore(cars));
    }

    private int calculateWinningScore(final List<Car> cars) {
        return cars.stream().mapToInt(Car::moveCount).max().orElse(0);
    }

    private List<String> findCarNameWithWinningScore(final List<Car> cars, final int winningScore){
        return cars.stream()
            .filter(car -> car.moveCount() == winningScore)
            .map(Car::carName)
            .collect(Collectors.toList());
    }
}
