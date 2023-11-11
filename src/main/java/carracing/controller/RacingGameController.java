package carracing.controller;

import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import carracing.domain.game.MaxMoving;
import carracing.domain.game.MovingStrategy;
import carracing.domain.game.RacingGame;
import carracing.domain.game.RandomRange;
import carracing.domain.game.WinnerStrategy;
import carracing.view.InputView;
import carracing.view.ResultView;

public class RacingGameController {
	public void race() {
		Cars racingCars = InputView.inputCars();
		RacingGame racingGame = new RacingGame(racingCars);
		MovingStrategy movingStrategy = new RandomRange(0, 9);
		int tryingTimes = InputView.inputTryingNumber();

		for (int i = 0; i < tryingTimes; i++) {
			racingGame.race(movingStrategy);
			ResultView.printMovingResult(racingCars);
		}

		ResultView.printResultPhrase();
		WinnerStrategy maxMoving = new MaxMoving();
		Winners winners = racingCars.winners(maxMoving);
		ResultView.printWinners(winners);
	}
}
