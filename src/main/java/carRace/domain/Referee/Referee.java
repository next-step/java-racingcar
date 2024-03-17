package carRace.domain.Referee;

import carRace.domain.car.Car;
import carRace.domain.car.CarGroup;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {

    public CarNames findWinnersName(final CarGroup carGroup) {
        return findCarNameWithWinningCar(carGroup, findWinningCar(carGroup));
    }

    private Car findWinningCar(final CarGroup carGroup) {
        return carGroup.getCarGroup().stream()
            .max(Car::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    private CarNames findCarNameWithWinningCar(final CarGroup carGroup, final Car winningCar){
        List<CarName> carNames = carGroup.getCarGroup().stream()
            .filter(car -> car.isSameMoveDistance(winningCar.getMoveDistance()))
            .map(Car::getCarName)
            .collect(Collectors.toList());
        return new CarNames(carNames);
    }
}
