package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        RacingCarGame racingCarGame = new RacingCarGame(carNames);
        int tryCount = InputView.inputTryCount();

        RacingRecord racingCarGameRecords = racingCarGame.play(new RandomValueMovingStrategy(), tryCount);
        CarsRecord winners = racingCarGame.findFinalWinner();

        ResultView.printResultMessage();
        ResultView.printRacingCars(racingCarGameRecords);
        ResultView.printWinner(winners);
    }
}
