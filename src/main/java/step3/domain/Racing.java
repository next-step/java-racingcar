package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.RandomUtils;

public class Racing {
	private final int trials;
	private final List<Car> cars = new ArrayList<>();

	public Racing(int trials, int cars) {
		this.trials = trials;
		this.cars.addAll(prepareCars(cars));
	}

	public List<RacingResult> race() {
		List<RacingResult> result = new ArrayList<>();

		for (int i = 0; i < trials; i++) {
			raceOneTrial();
			RacingResult racingResult = new RacingResult(trials, getResultOneTrial());
			result.add(racingResult);
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

	private List<Integer> getResultOneTrial() {
		return cars.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList());
	}
}
