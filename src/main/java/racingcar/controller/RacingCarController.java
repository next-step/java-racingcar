package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Cycle;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String names = InputView.inputCarInfo();
        Cycle cycle = new Cycle(InputView.inputCycle());

        Cars cars = new Cars(names.split(","));

        RacingGame racingGame = new RacingGame(cars, cycle);
        ResultView.showResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.showCarInformationForCycle(racingGame.getCars());
        }
        ResultView.showWinner(racingGame.selectWinners());
    }
}
