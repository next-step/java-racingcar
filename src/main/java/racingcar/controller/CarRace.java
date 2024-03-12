package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.NameSeparator;
import racingcar.domain.RandomCarMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRace(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void race() {
        String nameString = inputView.readCarNameString();
        int tryCount = inputView.readHowManyTrys();

        String[] names = separateNameString(nameString);
        Cars cars = createCars(names);

        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            resultView.appendSnapshot(cars);
        }

        resultView.printCarRaceResult();
    }

    private String[] separateNameString(String nameString) {
        NameSeparator nameSeparator = new NameSeparator(nameString);
        return nameSeparator.separate();
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }

}
