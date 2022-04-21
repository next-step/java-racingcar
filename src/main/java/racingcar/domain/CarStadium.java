package racingcar.domain;

import racingcar.ui.InputView;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.strategy.move.CarMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarStadium {
	private Cars cars;
	private int rounds;
	private String[] carNames;

	public CarStadium(InputView input) {
		this.carNames = input.getCarNames();
		this.rounds = input.getRounds();
	}

	public void racingStart() {
		carComes();

		for (int i = 0; i < this.rounds; i++) {
			eachCarMove();
			System.out.println();
		}
	}

	private void carComes() {
		List<Car> carList = new ArrayList<>();

		for (int i = 0; i < this.carNames.length; i++) {
			Car car = new Car(this.carNames[i]);
			carList.add(car);
		}

		this.cars = new Cars(carList);
	}

	private void eachCarMove() {
		for (int i = 0; i < cars.count(); i++) {
			Car car = cars.get(i);
			car.move();
			System.out.println(car.name() + ": " + car.carStatus());
		}
	}
}
