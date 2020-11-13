package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.CarDTO;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGame {

    private RacingGameController racingGameController;
    private InputView inputView;
    private ResultView resultView;

    public RacingGame() {
        this.racingGameController = new RacingGameController();
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
        racingGameController.createCarBy(racingCarNameList);
    }

    public void race() {
        int repeatCount = inputView.getRepeatCount();

        for (int count=0; count<repeatCount; count++) {
            List<CarDTO> race = racingGameController.race();
            resultView.showRacingResult(race);
        }
    }

    private void findWinner() {
        racingGameController.findWinner();
    }

}
