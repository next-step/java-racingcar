package carRace.domain;

import carRace.domain.car.Car;
import carRace.domain.car.MoveDistance;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {

    public List<String> findWinners(final List<Car> cars) {
        return findCarNameWithWinningScore(cars, calculateWinningScore(cars));
    }

    private MoveDistance calculateWinningScore(final List<Car> cars) {
        return cars.stream()
            .map(Car::getMoveDistance)
            .max(MoveDistance::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    private List<String> findCarNameWithWinningScore(final List<Car> cars, final MoveDistance moveDistance){
        return cars.stream()
            .filter(car -> car.getMoveDistance().equals(moveDistance.getMoveDistance()))
            .map(Car::carName)
            .collect(Collectors.toList());
    }
}
