package racing.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racing.exception.NotFoundMaxDistanceException;
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

	public String getTopRankResult() {
		String[] topNames = cars.stream()
			.filter(car -> car.checkVictory(measureMaxDistance()))
			.map(Car::getName)
			.toArray(String[]::new);

		return String.join(",", topNames);
	}

	private int measureMaxDistance() {
		return cars.stream()
			.max(Comparator.comparingInt(Car::getMove))
			.orElseThrow(() -> new NotFoundMaxDistanceException("최대 거리를 찾을 수 없습니다."))
			.getMove();
	}
}
