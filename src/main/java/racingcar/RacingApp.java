package racingcar;

import racingcar.service.RacingGame;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingApp {

    public static void main(String[] args) {
        List<String> carNames = InputValidator.validateCarNames(InputView.getInputCarName());
        int countOfRacingRound = InputValidator.validateInput(InputView.getCountOfRacingRound());

        RacingGame racingGame = new RacingGame(carNames, countOfRacingRound);
        racingGame.start();

        ResultView.displayRacingResult(racingGame.getRacingResult());
    }
}
