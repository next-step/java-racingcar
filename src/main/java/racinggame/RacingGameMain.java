package racinggame;

import racinggame.domain.Laps;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        Laps laps = inputView.inputLaps();

        RacingGame racingGame = new RacingGame(carCount, laps);
        racingGame.startRacing();

        ResultView resultView = new ResultView(racingGame.resultRacing(), laps.getCount());
        resultView.resultRacing();
    }
}
