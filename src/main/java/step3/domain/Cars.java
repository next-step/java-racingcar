package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.RandomNumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public void goOrStop() {
		cars.forEach(car -> car.goOrStop(getNumber()));
	}

	public int getNumber() {
		return RandomNumberGenerator.getInstance().generate();
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
