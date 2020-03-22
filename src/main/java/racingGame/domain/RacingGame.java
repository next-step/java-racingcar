package racingGame.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RacingGame {
	private static final int RANDOM_RANGE = 10;
	private static final int GO_THRESHOLD = 4;
	private List<Car> carPositions;

	public RacingGame(Car... cars) {
		this.carPositions = Arrays.stream(cars)
				.collect(Collectors.toList());
	}

	public List<Car> move() {
		carPositions.replaceAll((r, v) -> moveCar(carPositions.get(r)));
		return new HashMap<>(carPositions);
	}

	private int moveCar(int car) {
		if (canGo()) {
			car++;
		}
		return car;
	}

	private boolean canGo() {
		return Math.random() * RANDOM_RANGE > GO_THRESHOLD;
	}

	public List<String> getWinners() {
		return carPositions.entrySet()
				.stream()
				.filter(racer -> racer.getValue().equals(getWinnerPosition()))
				.map(Map.Entry::getKey)
				.toArray(String[]::new);
	}

	private int getWinnerPosition() {
		//noinspection OptionalGetWithoutIsPresent
		return carPositions.values()
				.stream()
				.max(Integer::compareTo)
				.get();
	}

}
