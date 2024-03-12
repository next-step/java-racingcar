package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomCarMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class CarRaceApp {

    public static void main(String[] args) {
        ResultView.printAnswerHowManyCars();
        int carCount = InputView.readInt();

        ResultView.printAnswerHowManyTrys();
        int tryCount = InputView.readInt();

        Cars cars = new Cars(carCount);
        ResultView.printExecuteResultString();
        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            ResultView.print(cars);
        }
    }

}
