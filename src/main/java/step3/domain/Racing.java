package step3.domain;

import java.util.ArrayList;
import java.util.List;

import step3.utils.RandomUtils;

public class Racing {
	private final int trials;
	private final List<Car> cars = new ArrayList<>();

	public Racing(int trials, int cars) {
		this.trials = trials;
		this.cars.addAll(prepareCars(cars));
	}

	public int[][] race() {
		int[][] result = new int[trials][cars.size()];

		for (int i = 0; i < trials; i++) {
			raceOneTrial();
			result[i] = getResultOneTrial();
		}

		return result;
	}

	private List<Car> prepareCars(int numberOfCars) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car());
		}
		return cars;
	}

	private void raceOneTrial() {
		cars.forEach(car -> {
			int randomNumber = RandomUtils.randomNumber();
			car.advanceOrStop(randomNumber);
		});
	}

	private int[] getResultOneTrial() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.toArray();
	}
}
