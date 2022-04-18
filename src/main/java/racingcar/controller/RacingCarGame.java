package racingcar.controller;

import racingcar.model.*;
import racingcar.pattern.ValueGenerateStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final ValueGenerateStrategy valueGenerateStrategy;

    public RacingCarGame(ValueGenerateStrategy valueGenerateStrategy) {
        this.valueGenerateStrategy = valueGenerateStrategy;
    }

    public void gameStart() {
        PositiveNumber carNumber = new PositiveNumber(InputView.carNumber());
        PositiveNumber trialNumber = new PositiveNumber(InputView.trialNumber());

        OutputView.guide();
        racingCarGame(carNumber, trialNumber);
    }

    private void racingCarGame(PositiveNumber carNumber, PositiveNumber trialNumber) {
        List<Car> cars = CarGroup.createCars(carNumber);
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(trialNumber, valueGenerateStrategy);

        Map<Identity, CarMoveDistance> CarMoveDistanceMap = getCarMoveDistanceMap(cars);
        for (int trialStep = 0; trialStep < trialNumber.getNumber(); trialStep++) {
            OutputView.racingResult(new PositiveNumber(trialStep), CarMoveDistanceMap);
        }
    }

    private Map<Identity, CarMoveDistance> getCarMoveDistanceMap(List<Car> cars) {
        return cars.stream().collect(Collectors.toMap(Car::getId, car -> new CarMoveDistance(car.getMoveDistanceTrace())));
    }
}
