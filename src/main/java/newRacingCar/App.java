package newRacingCar;

import newRacingCar.domain.RacingCarGame;
import newRacingCar.domain.RandomMoveStrategy;
import newRacingCar.view.InputView;
import newRacingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputCarNames(), inputView.inputTryTimes());

        for (int i = 0; i < racingCarGame.getTryTimes(); i++) {
            resultView.printCarRace(racingCarGame.move(new RandomMoveStrategy()));;
        }

        resultView.printWinners(racingCarGame.findWinners());
    }
}
