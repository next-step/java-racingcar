package racingcar;

import java.util.List;

import racingcar.domain.RacingCars;
import racingcar.domain.EngineRandomStrategy;
import racingcar.domain.CountOfGamePlay;
import racingcar.domain.CarNames;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.RoundResult;
import racingcar.view.ResultView;

public class RacingCarApplication {
	public static void main(String[] args) {
		CarNames carNames = InputView.inputCarNames();
		int playCount = InputView.inputPlayCount();

		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(playCount);

		RacingCars racingCars = RacingCars.of(carNames);

		List<RoundResult> roundResults = countOfGamePlay.run(racingCars, new EngineRandomStrategy());

		ResultView.printGameRound(roundResults);
		ResultView.printWinner(racingCars.rankWinners());
	}
}
