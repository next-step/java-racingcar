package simpleracing.execute;

import java.util.List;

import simpleracing.input.CarRacingInitValue;
import simpleracing.input.InputView;
import simpleracing.output.OutputView;


public class CarRacingExecutor {

	public void execute() {
		CarRacingInitValue initValue = InputView.input();
		List<Car> cars = this.playGame(initValue);
		this.render(cars);
	}

	private List<Car> playGame(CarRacingInitValue initValue) {
		CarRacingGame game = new CarRacingGame(initValue);
		return game.play();
	}

	private void render(List<Car> cars) {
		OutputView outputView = new OutputView(cars);
		outputView.render();
	}
}
