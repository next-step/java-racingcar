package simpleracing.execute;

import java.util.stream.IntStream;

import simpleracing.input.CarRacingInitValue;
import simpleracing.input.CarRacingInput;
import simpleracing.output.CarRacingOutput;


public class CarRacingExecutor {

	private CarRacingInput carRacingInput = new CarRacingInput();
	private CarGame racingGame;
	private CarRacingOutput carRacingOutput;

	public void execute() {
		CarRacingInitValue initValue = this.init();
		this.play(initValue.getTryCount());
		carRacingOutput.render();
	}

	private void play(int tryCount) {
		IntStream.range(0, tryCount)
				 .forEach(i -> {
					 racingGame.play();
				 });
		racingGame.judge(new CarRacingReferee());
	}

	private CarRacingInitValue init() {
		CarRacingInitValue initValue = carRacingInput.input();
		this.racingGame = new CarRacingGame(initValue);
		this.carRacingOutput = new CarRacingOutput(racingGame);

		return initValue;
	}
}
