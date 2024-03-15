package carRace.domain.Referee;

import carRace.domain.car.Car;
import carRace.domain.car.CarGroups;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import carRace.domain.car.MoveDistance;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {

    public CarNames findWinners(final CarGroups cars) {
        return findCarNameWithWinningScore(cars, findWinningScore(cars));
    }

    private MoveDistance findWinningScore(final CarGroups cars) {
        return cars.getCarGroups().stream()
            .map(Car::getMoveDistance)
            .max(MoveDistance::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    private CarNames findCarNameWithWinningScore(final CarGroups cars, final MoveDistance moveDistance){
        List<CarName> carNames = cars.getCarGroups().stream()
            .filter(car -> car.getMoveDistance().equals(moveDistance))
            .map(Car::getCarName)
            .collect(Collectors.toList());
        return new CarNames(carNames);
    }
}
