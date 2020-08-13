package simpleracing.domain.executor;

import simpleracing.domain.game.CarGame;
import simpleracing.domain.game.CarRacingGame;
import simpleracing.domain.tools.CarRacingReferee;
import simpleracing.domain.tools.CarRacingResult;
import simpleracing.view.input.CarRacingInitValue;
import simpleracing.view.input.CarRacingInput;
import simpleracing.view.output.CarRacingOutput;


public class CarRacingExecutor {
	private CarGame racingGame;

	public void execute() {
		CarRacingInitValue initValue = this.init();
		CarRacingResult result = racingGame.play(initValue.getNumberOfAttempts());
		CarRacingOutput.render(result);
	}

	private CarRacingInitValue init() {
		CarRacingInitValue initValue = CarRacingInput.input();
		this.racingGame = new CarRacingGame(initValue, new CarRacingReferee());

		return initValue;
	}
}
