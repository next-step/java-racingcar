package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.ui.InputView;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.strategy.move.CarMoveStrategy;

public class CarStadium {
	private Cars cars;
	private int rounds;
	private int numberOfCars;

	public CarStadium(InputView input) {
		this.numberOfCars = input.getNumberOfCars();
		this.rounds = input.getRounds();
	}

	public int getRounds() {
		return rounds;
	}

	public Cars getCars() {
		return cars;
	}

	public void carComes() {
		List<Car> carList = new ArrayList<>();

		for (int i = 0; i < this.numberOfCars; i++) {
			Car car = new Car(new RandomNumberGenerator(), new CarMoveStrategy());
			carList.add(car);
		}

		this.cars = new Cars(carList);
	}
}
