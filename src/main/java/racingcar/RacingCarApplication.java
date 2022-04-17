package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.GameRule;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.Results;
import util.RandomUtil;

public class RacingCarApplication {
	public static void main(String[] args) {
		int carCount = InputView.inputCarCount();
		int playCount = InputView.inputPlayCount();

		RacingCarGame game = new RacingCarGame(Cars.of(carCount), playCount);
		Results results = game.start(
			() -> RandomUtil.createRandomNumber(GameRule.RANDOM_MIN, GameRule.RANDOM_MAX));

		ResultView.print(results);
	}
}
