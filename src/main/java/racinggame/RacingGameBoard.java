package racinggame;

import java.util.List;

/**
 * Created by hspark on 03/11/2018.
 */
public class RacingGameBoard {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		RacingGame racingGame = inputView.input();
		while (racingGame.hasNextGame()) {
			List<Car> carList = racingGame.move();
			resultView.output(carList);
		}
	}
}
