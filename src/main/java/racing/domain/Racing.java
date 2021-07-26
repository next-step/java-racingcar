package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racing.utils.RandomUtils;

public class Racing {

	private List<Car> cars;

	public Racing(String[] names) {
		initCars(names);
	}

	private void initCars(String[] names) {
		cars = Arrays.stream(names)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Car> move() {
		cars.forEach(car -> car.move(RandomUtils.getRandomValue()));

		return cars;
	}
}
