package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.car.Cars;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final RacingGameController racingGameController = new RacingGameController();
        final Cars cars = racingGameController.initCars(inputView);

        RoundHistories roundHistories = racingGameController.race(inputView, cars);

        ResultView resultView = new ResultView();
        resultView.printResult(cars, roundHistories);
    }


}
