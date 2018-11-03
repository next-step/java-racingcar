package racinggame;

import racinggame.rule.RandomNumberRacingGameRule;

/**
 * Created by hspark on 03/11/2018.
 */
public class RacingGameBoard {

	public static void main(String[] args) {
		int carAmount = InputView.inputInt(InputMessageType.CAR_AMOUNT);
		int tryCount = InputView.inputInt(InputMessageType.TRY_COUNT);

		RacingGame racingGame = new RacingGame(carAmount, tryCount, new RandomNumberRacingGameRule());
		while (racingGame.hasNextGame()) {
			racingGame.move();
			ResultView.output(racingGame.getCarDtoList());
		}
	}
}
