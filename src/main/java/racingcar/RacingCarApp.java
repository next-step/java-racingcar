package racingcar;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> racingCarNameList = inputView.getRacingCarNames();
        int racingRound = inputView.getRacingRound();

        RacingGame racingGame = new RacingGame(racingCarNameList, racingRound);
        racingGame.start();

        ResultView resultView = new ResultView(racingGame.getRacingResults());
        resultView.displayRacing();
    }
}
