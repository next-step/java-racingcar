package racing;

import racing.car.CarList;
import racing.game.Game;
import racing.game.RandomNextIntImpl;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		int numberOfCars = inputView.cars();
		int numberOfAttempts = inputView.attempts();

		Game game = new Game(new RandomNextIntImpl(10));
		CarList cars = new CarList(numberOfCars);

		ResultView resultView = new ResultView();
		for (int i = 0; i < numberOfAttempts; i++) {
			cars.moveAll(game.bounds(numberOfCars));
			resultView.print(cars);
		}

	}
}
