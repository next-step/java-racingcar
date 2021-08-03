package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.RandomUtils;

public class Cars {
	private final List<Car> cars;

	public Cars(int numberOfCars) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			Car car = new Car();
			cars.add(car);
		}
		this.cars = cars;
	}

	public void raceOneTrial() {
		cars.forEach(car -> {
			int randomNumber = RandomUtils.randomNumber();
			car.advanceOrStop(randomNumber);
		});
	}

	public List<Integer> getResultOneTrial() {
		return cars.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList());
	}
}
