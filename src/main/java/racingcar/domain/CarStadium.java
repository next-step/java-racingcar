package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.ui.InputView;

public class CarStadium {
	private Cars cars;

	public void race() {
		eachCarMove();
	}

	public String showWinners() {
		List<Car> winners = Winners.list(cars);
		String carNames = winners.stream().map(Car::name).collect(Collectors.joining(","));
		return carNames;
	}

	public Cars carComes(String[] carNames) {
		List<Car> carList = new ArrayList<>();

		for (int i = 0; i < carNames.length; i++) {
			Car car = new Car(carNames[i]);
			carList.add(car);
		}
		this.cars = new Cars(carList);

		return this.cars;
	}

	private void eachCarMove() {
		for (int i = 0; i < cars.count(); i++) {
			Car car = cars.get(i);
			car.move();
		}
	}
}
