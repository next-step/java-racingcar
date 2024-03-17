package carRace.domain.Referee;

import carRace.domain.car.Car;
import carRace.domain.car.CarGroup;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import carRace.domain.car.MoveDistance;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {

    public CarNames findWinners(final CarGroup carGroup) {
        return findCarNameWithWinningScore(carGroup, findWinningScore(carGroup));
    }

    private MoveDistance findWinningScore(final CarGroup carGroup) {
        return carGroup.getCarGroup().stream()
            .map(Car::getMoveDistance)
            .max(MoveDistance::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    private CarNames findCarNameWithWinningScore(final CarGroup carGroup, final MoveDistance moveDistance){
        List<CarName> carNames = carGroup.getCarGroup().stream()
            .filter(car -> car.getMoveDistance().equals(moveDistance))
            .map(Car::getCarName)
            .collect(Collectors.toList());
        return new CarNames(carNames);
    }
}
