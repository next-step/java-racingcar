package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String carNames = InputView.inputCarInfo();
        int cycle = InputView.inputCycle();

        RacingGame racingGame = new RacingGame(carNames, cycle);

        ResultView.showResult();
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.cycleCarInformation(racingGame.getCars());
        }
        ResultView.showWinner(racingGame.selectWinners());
    }
}
