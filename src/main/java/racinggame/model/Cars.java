package racinggame.model;

import racinggame.util.RandomValueUtil;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Cars {
	private final List<Car> cars;
	private final static int MOVE_VALUE = 4;

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

	public void carsMove() {
		cars.stream()
			  .filter(c -> isMove())
			  .forEach(Car::move);
	}

	public List<String> viewCarsStatus() {
		return cars.stream()
							 .map(Car::viewStatus)
							 .collect(toList());
	}

	private boolean isMove() {
		return RandomValueUtil.getRandomValue() >= MOVE_VALUE;
	}
}
