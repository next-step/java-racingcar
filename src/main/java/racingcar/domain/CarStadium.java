package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.ui.InputView;

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

	public void showWinners() {
		List<Car> winners = Winners.list(cars);
		String carNames = winners.stream().map(Car::name).collect(Collectors.joining(","));
		System.out.println("우승자는 " + carNames + " 입니다");
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
