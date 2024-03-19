package racingcar;

import io.InputView;
import io.PrintView;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public void play() {
		String[] carNames = InputView.inputNamesOfCar();
		int numberOfTrial = InputView.inputNumberOfTrial();

		List<Car> cars = setCars(carNames);

		PrintView.printResultMessage();

		for(int i = 0; i < numberOfTrial; i++) {
			tryGame(cars);
		}

		Ranking ranking = new Ranking(cars);
		PrintView.printWinnerMessage(ranking.getWinners());
	}

	private List<Car> setCars(String[] carNames) {
		List<Car> cars = new ArrayList<>();

		for(String carName : carNames) {
			cars.add(new Car(carName, new RandomCarMoveStrategy()));
		}

		return cars;
	}

	private void tryGame(List<Car> cars) {
		for(Car car : cars) {
			car.move();
			PrintView.printCarMoving(car);
		}

		PrintView.printEmptyLine();
	}
}
