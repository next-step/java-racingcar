package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.RandomUtils;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] names) {
		this.cars = Arrays.stream(names)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void raceOneTrial() {
		cars.forEach(car -> {
			int randomNumber = RandomUtils.randomNumber();
			car.advanceOrStop(randomNumber);
		});
	}

	public List<Car> getCars() {
		return cars;
	}
}
