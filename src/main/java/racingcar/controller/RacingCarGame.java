package racingcar.controller;

import racingcar.model.*;
import racingcar.pattern.ValueGenerateStrategy;
import racingcar.util.SplitString;
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
        List<String> carNames = SplitString.split(InputView.carNames());
        PositiveNumber trialNumber = new PositiveNumber(InputView.trialNumber());

        OutputView.guide();
        racingCarGame(carNames, trialNumber);
    }

    private void racingCarGame(List<String> carNames, PositiveNumber trialNumber) {
        List<Car> cars = CarGroup.createCars(carNames);
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(trialNumber, valueGenerateStrategy);

        Map<Identity, CarMoveDistance> carMoveDistanceMap = getCarMoveDistanceMap(cars);
        for (int trialStep = 0; trialStep < trialNumber.getNumber(); trialStep++) {
            OutputView.racing(new PositiveNumber(trialStep), carMoveDistanceMap);
        }
        OutputView.printRacingGameResult(carGroup.getWinners());
    }

    private Map<Identity, CarMoveDistance> getCarMoveDistanceMap(List<Car> cars) {
        return cars.stream().collect(Collectors.toMap(Car::getId, car -> new CarMoveDistance(car.getMoveDistanceTrace())));
    }
}
