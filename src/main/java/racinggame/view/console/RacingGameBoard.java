package racinggame.view.console;

import racinggame.domain.RacingGame;
import racinggame.domain.rule.RandomNumberRacingGameRule;

/**
 * Created by hspark on 03/11/2018.
 */
public class RacingGameBoard {

	public static void main(String[] args) {
		String[] carNames = InputView.inputString(InputMessageType.CAR_NAME).split(",");
		int tryCount = InputView.inputInt(InputMessageType.TRY_COUNT);

		RacingGame racingGame = new RacingGame(carNames, tryCount, new RandomNumberRacingGameRule());
		while (racingGame.hasNextGame()) {
			racingGame.move();
			ResultView.printGameResult(racingGame.getGameResult());
		}
		ResultView.printTopRankingList(racingGame.getGameResult());
	}
}
