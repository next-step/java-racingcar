package racingGame.logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RacingGame {
	private static final int RANDOM_RANGE = 10;
	private static final int GO_THRESHOLD = 4;
	private Map<String, Integer> carPositions;

	public RacingGame(String... racers) {
		this.carPositions = Arrays.stream(racers)
				.collect(Collectors.toMap(Function.identity(), racer -> 0));
	}

	public Map<String, Integer> move() {
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

	public String[] getWinners() {
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
