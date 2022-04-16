package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.ui.InputView;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.strategy.move.CarMoveStrategy;

public class CarStadium {
	private final List<Car> cars = new ArrayList<>();
	private int rounds;
	private final int numberOfCars;

	public CarStadium(InputView input) {
		this.numberOfCars = input.getNumberOfCars();
		rounds = input.getRounds();
		carComes();
	}

	public int getRounds() {
		return rounds;
	}

	public List<Car> getCars() {
		return cars;
	}

	private void carComes() {
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car(new RandomNumberGenerator(), new CarMoveStrategy()));
		}
	}
}
