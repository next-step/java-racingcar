package racing;

import racing.model.CarList;
import racing.game.Game;
import racing.random.RandomReturnZeroToNine;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();

		String[] inputs = inputView.cars();
		int numberOfCars = inputs.length;
		try {
			int numberOfAttempts = inputView.attempts();

			CarList cars = new CarList(numberOfCars, inputs);
			Game game = new Game(new RandomReturnZeroToNine());

			ResultView resultView = new ResultView();
			resultView.printCars(cars);
			for (int i = 0; i < numberOfAttempts; i++) {
				cars.moveAll(game.bounds(numberOfCars));
				resultView.printCars(cars);
			}
			resultView.printWinners(cars.winners());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
