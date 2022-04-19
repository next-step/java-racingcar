package racingcar;

import racingcar.domain.RacingCars;
import racingcar.domain.EngineRandomStrategy;
import racingcar.domain.CountOfGamePlay;
import racingcar.domain.CarNames;
import racingcar.view.InputView;

public class RacingCarApplication {
	public static void main(String[] args) {
		CarNames carNames = InputView.inputCarNames();
		int playCount = InputView.inputPlayCount();

		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(playCount);

		countOfGamePlay.run(RacingCars.of(carNames), new EngineRandomStrategy());

		// ResultView.print(results);
	}
}
