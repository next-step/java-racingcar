package racingCar;

import racingCar.model.RacingCarGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputCarNames(), inputView.inputTryTimes());

        for (int i =0; i < racingCarGame.getTryTimes(); i++) {
            racingCarGame.moveCars();
            resultView.printCarRace(racingCarGame.getRaceCar());
        }

        resultView.printWinners(racingCarGame.winnersCars());
    }
}
