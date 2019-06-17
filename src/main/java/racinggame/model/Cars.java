package racinggame.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Cars {
	private final List<Car> cars;

	public Cars(int carCount) {
		cars = IntStream.range(0, carCount)
										.mapToObj(i -> new Car())
										.collect(toList());
	}

	public int[] getCarsStatus() {
		return cars.stream()
							 .mapToInt(Car::getStatus)
			         .toArray();
	}
}
