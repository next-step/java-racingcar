package carRace.domain.Referee;

import carRace.domain.car.Car;
import carRace.domain.car.CarGroup;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public CarNames findWinnersName(final CarGroup carGroup) {
        return findCarNameWithWinningCar(carGroup, carGroup.findWinningCar());
    }

    private CarNames findCarNameWithWinningCar(final CarGroup carGroup, final Car winningCar){
        return carGroup.findCarNames(winningCar);
    }
}
