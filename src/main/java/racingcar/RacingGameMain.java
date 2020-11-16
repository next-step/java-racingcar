package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.CarDTO;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;
import java.util.Map;

public class RacingGameMain {
    private RacingGameController racingGameController;
    private InputView inputView;
    private ResultView resultView;

    public RacingGameMain() {
        this.racingGameController = new RacingGameController();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        createRacingCar();
        race();
        showWinners();
    }

    private void createRacingCar() {
        racingGameController.createRacingCars(inputView.inputCarNames());
    }

    private void race() {
        Map<Integer, List<CarDTO>> racingResult = racingGameController.race(inputView.getRepeatCount());
        resultView.showRacingResult(racingResult);
    }

    private void showWinners() {
        resultView.show(racingGameController.findWinner());
    }
}
