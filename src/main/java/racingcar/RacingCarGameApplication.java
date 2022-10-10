package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.RacingCarGame;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);
        RacingCarGameController racingCarGameController = new RacingCarGameController(racingCarGame);
        RacingRecord racingCarGameRecords = racingCarGameController.play();
        CarsRecord winners = racingCarGameController.findFinalWinner();

        ResultView.printResultMessage();
        ResultView.printRacingCars(racingCarGameRecords);
        ResultView.printWinner(winners);
    }
}
