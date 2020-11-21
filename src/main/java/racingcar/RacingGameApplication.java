package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.input();
        Cars cars = new Cars(inputView.getCarNames());
        RacingGame racingGame = RacingGame.newRacingGame(cars, inputView.getRounds());
        racingGame.play();
        resultView.print(racingGame);
    }
}
