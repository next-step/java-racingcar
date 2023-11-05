package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.validite.ValidityCheck;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private static final String CAR_NAME_SPLIT = ",";

    public void startRace(String carNames, int moveNumber) {
        ValidityCheck.positiveNumberCheck(moveNumber);
        List<String> carNameList = List.of(carNames.split(CAR_NAME_SPLIT));
        CarCollection carCollection = new CarCollection();
        carCollection.participants(carNameList);
        List<Car> cars = carCollection.getCars();
        OutputView outputView = new OutputView();

        for (int i = 0; i < moveNumber; i++) {
            carCollection.moveCars();
            outputView.print(cars.stream().map(Car::toString).collect(Collectors.toList()));
        }
        outputView.print(carCollection.getWinner());
    }
}
