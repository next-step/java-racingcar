package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.dto.RacingRecord;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        String carName = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carName, tryCount);
        RacingRecord racingCarGameRecords = racingCarGame.play(new RandomValueMovingStrategy());
        List<Car> winners = racingCarGame.finish();

        ResultView.printResultMessage();
        ResultView.printRacingCars(racingCarGameRecords);
        ResultView.printWinner(winners);
    }
}
