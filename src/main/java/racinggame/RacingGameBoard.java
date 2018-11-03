package racinggame;

import racinggame.rule.RandomNumberRacingGameRule;
import racinggame.view.InputMessageType;
import racinggame.view.InputView;
import racinggame.view.ResultView;

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
			ResultView.printGameResult(racingGame.getCarDtoList());
		}
		ResultView.printTopRankingList(racingGame.getTopRankingCarDtoList());
	}
}
