package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.Result;

public class Cars {
	private final List<Car> cars;

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

	public int size() {
		return cars.size();
	}

	public boolean isSameSize(int size) {
		return cars.size() == size;
	}

	public Result result() {
		return new Result(cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList()));
	}
}
