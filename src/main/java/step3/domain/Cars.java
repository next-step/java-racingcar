package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step3.utils.NumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public Cars(CarNumber carNumber) {
		this(createCars(carNumber));
	}

	static List<Car> createCars(CarNumber carNumber) {
		return IntStream.range(0, carNumber.getNumber())
			.boxed()
			.map(integer -> new Car())
			.collect(Collectors.toList());
	}

	public void goOrStop(NumberGenerator numberGenerator) {
		cars.forEach(car -> car.goOrStop(numberGenerator.generate()));
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
