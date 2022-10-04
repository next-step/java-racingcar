package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.dto.CarsDto;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        String carName = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarWinnerGame = new RacingCarGame(carName, tryCount);
        List<CarsDto> racingCarGameRecords = racingCarWinnerGame.play(new RandomValueMovingStrategy());
        List<Car> winners = racingCarWinnerGame.findWinner();

        ResultView.printResultMessage();
        ResultView.printRacingCars(racingCarGameRecords);
        ResultView.printWinner(winners);
    }
}
