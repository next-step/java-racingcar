package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.validite.ValidityCheck;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private static final String CAR_NAME_SPLIT = ",";
    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();

    public void startRace(String carNames, int moveNumber) {
        ValidityCheck.positiveNumberCheck(moveNumber);
        List<String> carNameList = List.of(carNames.split(CAR_NAME_SPLIT));
        CarCollection carCollection = new CarCollection();
        carCollection.participants(carNameList);
        List<Car> cars = carCollection.getCars();
        OutputView outputView = new OutputView();

        for (int i = 0; i < moveNumber; i++) {
            carCollection.moveCars(MOVE_STRATEGY);
            outputView.print(cars.stream().map(Car::toString).collect(Collectors.toList()));
        }
        outputView.print(carCollection.getWinner());
    }
}
