package racingcar;

import racingcar.service.RacingGame;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingApp {

    public static void main(String[] args) {
        List<String> carNames = InputValidator.validateCarName(InputView.getInputCarName());
        int countOfRacingRound = InputValidator.validateRound(InputView.getCountOfRacingRound());

        RacingGame racingGame = new RacingGame(carNames, countOfRacingRound);
        racingGame.start();

        ResultView.displayRacingResult(racingGame.getRacingResult());
    }
}
