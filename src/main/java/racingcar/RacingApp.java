package racingcar;

import racingcar.service.RacingGame;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingApp {
    public static void main(String[] args) {
        int countOfRacingCar = InputValidator.validateInput(InputView.getCountOfRacingCar());
        int countOfRacingRound = InputValidator.validateInput(InputView.getCountOfRacingRound());

        RacingGame racingGame = new RacingGame(countOfRacingCar, countOfRacingRound);
        racingGame.start();

        ResultView.displayRacing(racingGame.getRacingResult());
    }
}
