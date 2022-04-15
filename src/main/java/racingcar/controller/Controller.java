package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.model.Cars;
import racingcar.service.GameService;

public class Controller {
    public static void main(String[] args) {
        InputView.askCars();
        String carList = InputView.nextString();
        Cars cars = new Cars(carList);

        InputView.askTryCount();
        int playCount = InputView.nextInt();

        GameService.start(cars, playCount);

        ResultView.printWinners(cars);
    }
}
