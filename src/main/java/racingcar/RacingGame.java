package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
	private static final int START_LOCATION = 0;
	private final List<Car> cars = new ArrayList<>();
	private final List<Round> rounds = new ArrayList<>();

	public RacingGame(Integer totalCarSum) {
		init(totalCarSum);
	}

	private void init(Integer totalCarSum) {
		cars.addAll(
			Stream.generate(() -> new Car(START_LOCATION))
			.limit(totalCarSum)
			.collect(Collectors.toList())
		);
	}

	public void playRounds(int totalRound) {
		for (int i = 0; i < totalRound; i++) {
			play();
		}
	}

	private void play() {
		for (Car car : cars) {
			car.moveByRule();
		}
		rounds.add(new Round(clone(cars)));
	}

	private List<Car> clone(List<Car> cars) {
		List<Car> clone = new ArrayList<>();
		for (Car car : cars) {
			clone.add(new Car(car.getLocation()));
		}
		return clone;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}
}
