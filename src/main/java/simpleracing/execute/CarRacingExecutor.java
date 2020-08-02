package simpleracing.execute;

import simpleracing.input.CarRacingInitValue;
import simpleracing.input.InputView;


public class CarRacingExecutor {
	private CarRacingInitValue initValue;

	public CarRacingInitValue getInitValue() {
		return initValue;
	}

	public void execute() {
		this.initValue = InputView.input();

	}
}
