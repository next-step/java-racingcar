package racingcar;

import java.util.List;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
	public static void main(String[] args) {
		List<String> carNames = InputView.totalCarNames();
		int tryCount = InputView.totalTryCount();

		ResultView.printResultHeader();
		ResultView.printTotalRacingResult(RacingCar.race(carNames, tryCount));
	}
}
