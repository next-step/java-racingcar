package racing;

import racing.car.CarList;
import racing.game.Game;
import racing.game.RandomReturnZeroToNine;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();

		String[] inputs = inputView.cars();
		int numberOfCars = inputs.length;
		int numberOfAttempts = inputView.attempts();

		Game game = new Game(new RandomReturnZeroToNine());
		CarList cars = new CarList(numberOfCars, inputs);

		ResultView resultView = new ResultView();
		for (int i = 0; i < numberOfAttempts; i++) {
			cars.moveAll(game.bounds(numberOfCars));
			resultView.print(cars);
		}

	}
}
