package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}
	public static Cars of(int carCount) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
		return new Cars(cars);
	}

	public void play(RandomGenerator randomGenerator) {
		cars.forEach(
			car -> car.run(randomGenerator.generate()));
	}

	public List<Integer> getCarsMove() {
		return cars.stream()
			.map(Car::getMove)
			.collect(Collectors.toList());
	}
}
