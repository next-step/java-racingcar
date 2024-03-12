package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.NameSeparator;
import racingcar.domain.Names;
import racingcar.domain.RandomCarMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class CarRaceApp {

    public static void main(String[] args) {
        String nameString = InputView.readCarNameString();
        int tryCount = InputView.readHowManyTrys();

        Names names = new Names(new NameSeparator(nameString));
        Cars cars = new Cars(names);

        ResultView.printExecuteResultString();
        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            ResultView.print(cars);
        }
    }

}
