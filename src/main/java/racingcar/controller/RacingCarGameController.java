package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameController {
    private RacingCarGameController() {
    }

    public static void game() {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);
        RacingRecord play = racingCarGame.play(new RandomValueMovingStrategy());
        CarsRecord finalWinner = racingCarGame.findFinalWinner();

        ResultView.printResultMessage();
        ResultView.printRacingCars(play);
        ResultView.printWinner(finalWinner);
    }
}
