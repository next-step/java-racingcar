package controller;

import racingcar.CarMoveStrategy;
import racingcar.Cars;
import racingcar.StrategyFactory;
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
		CarMoveStrategy[] carMoveStrategies = StrategyFactory.getCarMoveStrategies();

		return new Cars(carNames, carMoveStrategies);
	}

	private void tryGame(Cars cars) {
		PrintView.printPosition(cars.move());

		PrintView.printEmptyLine();
	}
}
