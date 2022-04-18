package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.GameRule;
import racingcar.domain.CountOfGamePlay;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.Results;
import util.RandomUtil;

public class RacingCarApplication {
	public static void main(String[] args) {
		int carCount = InputView.inputCarCount();
		int playCount = InputView.inputPlayCount();

		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(playCount);

		Results results = countOfGamePlay.run(Cars.of(carCount),
			() -> RandomUtil.createRandomNumber(GameRule.RANDOM_MIN, GameRule.RANDOM_MAX));

		ResultView.print(results);
	}
}
