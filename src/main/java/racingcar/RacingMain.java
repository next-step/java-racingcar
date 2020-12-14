package racingcar;

import racingcar.domain.Scoreboard;
import racingcar.service.Racing;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(new Racing());

        String[] racers = inputView.getRacerNames();
        int move = inputView.getNumberOfRacing();

        Scoreboard result = racingGame.setInRacingByName(racers, move);
        ResultView resultView = new ResultView();
        resultView.racingResult(result);
    }

}
