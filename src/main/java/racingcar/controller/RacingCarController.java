package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String names = InputView.inputCarInfo();
        int cycle = InputView.inputCycle();

        Cars cars = new Cars();
        String[] carNames = names.split(",");
        for (String carName : carNames) {
            cars.addCars(carName);
        }

        RacingGame racingGame = new RacingGame(cars, cycle);
        ResultView.showResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.cycleCarInformation(racingGame.getCars());
        }
        ResultView.showWinner(racingGame.selectWinners());
    }
}
