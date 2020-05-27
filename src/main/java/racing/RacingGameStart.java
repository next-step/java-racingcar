package racing;

import racing.domain.car.RacingCars;
import racing.domain.game.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameStart {

    public static void main(String[] args) {
        String inputNames = InputView.inputCarNames();
        int times = InputView.inputTime();

        RacingCars racingCars = new RacingCars(inputNames);
        RacingGame racingGame = new RacingGame(racingCars);

        ResultView.resultMessage();
        racingGame.race(times);
        ResultView.printWinner(racingGame);
    }
}
