package controller;

import racingcar.car.Cars;
import racingcar.car.strategy.MultipleStrategy;
import racingcar.car.strategy.RandomCarMoveStrategy;
import view.InputView;
import view.PrintView;

public class Game {
	public void play() {
		String[] carNames = InputView.inputNamesOfCar();
		int numberOfTrial = InputView.inputNumberOfTrial();

		Cars cars = setCars(carNames);

		PrintView.printResultMessage();

		for(int i = 0; i < numberOfTrial; i++) {
			tryGame(cars);
		}

		PrintView.printWinnerMessage(cars.getWinners());
	}

	private Cars setCars(String[] carNames) {
		return new Cars(carNames, new MultipleStrategy(new RandomCarMoveStrategy()));
	}

	private void tryGame(Cars cars) {
		PrintView.printPosition(cars.move());

		PrintView.printEmptyLine();
	}
}
