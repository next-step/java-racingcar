package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MovingRule;
import racingcar.domain.RandomMovingRule;
import racingcar.domain.RacingCarGame;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;
import util.RandomUtil;

public class RacingCarApplication {
	public static void main(String[] args) {
		int carCount = InputView.inputCarCount();
		int playCount = InputView.inputPlayCount();

		RacingCarGame game = new RacingCarGame(Cars.of(carCount), playCount);
		game.start(new RandomMovingRule(
			() -> RandomUtil.createRandomNumber(RandomMovingRule.RANDOM_MIN, RandomMovingRule.RANDOM_MAX)));

		ResultView.print(game.getResults());
	}
}
