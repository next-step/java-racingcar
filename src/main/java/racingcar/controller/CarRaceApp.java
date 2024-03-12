package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomCarMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class CarRaceApp {

    public static void main(String[] args) {
        int carCount = InputView.readHowManyCars();
        int tryCount = InputView.readHowManyTrys();

        Cars cars = new Cars(carCount);

        ResultView.printExecuteResultString();
        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            ResultView.print(cars);
        }
    }

}
