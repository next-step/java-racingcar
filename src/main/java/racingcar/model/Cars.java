package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.Main;
import racingcar.util.Input;

public final class Cars {
	private List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> cars() {
		return cars;
	}

	public int size() {
		return cars.size();
	}

	public void createCar(final Car car) {
		cars.add(car);
	}

	public Car car(final Integer num) {
		return cars.get(num);
	}

	public List<Car> createCars(final List<String> carNames) {
		for (int carNum = 0; carNum < carNames.size(); carNum++) {
			Input.validateInput(carNames.get(carNum));
			Car car = new Car(carNames.get(carNum));
			createCar(car);
		}
		return cars;
	}
}
