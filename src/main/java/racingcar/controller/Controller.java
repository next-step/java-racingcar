package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.model.Cars;
import racingcar.service.GameService;

public class Controller {
    public static void main(String[] args) {
        String carList = InputView.askCars( );
        Cars cars = new Cars(carList);

        int playCount = InputView.askTryCount();

        GameService.start(cars, playCount);

        ResultView.printWinners(cars);
    }
}
