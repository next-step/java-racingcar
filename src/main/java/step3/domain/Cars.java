package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.NumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(Names names) {
		this.cars = Collections.unmodifiableList((createCars(names)));
	}

	static List<Car> createCars(Names names) {
		return names.getNameList()
			.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void goOrStop(NumberGenerator numberGenerator) {
		cars.forEach(car -> car.goOrStop(numberGenerator.generate()));
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
