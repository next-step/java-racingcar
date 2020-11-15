package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.CarDTO;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGameController {

    private RacingGame racingGame;
    private InputView inputView;
    private ResultView resultView;

    public RacingGameController() {
        this.racingGame = new RacingGame();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        this.startRacingGame();
        this.race();
        this.findWinner();
    }

    public void startRacingGame() {
        String racingCarNameList = inputView.findRacingCarNameList();
        racingGame.createCarBy(racingCarNameList);
    }

    public void race() {
        int repeatCount = inputView.getRepeatCount();

        for (int count = 0; count < repeatCount; count++) {
            List<CarDTO> race = racingGame.race();
            resultView.showRacingResult(race);
        }
    }

    public void findWinner() {
        List<CarDTO> winners = racingGame.findWinner();
        resultView.show(winners);
    }
}
