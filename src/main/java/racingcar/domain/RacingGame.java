package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private static final int START_LOCATION = 0;
	private final List<Car> cars = new ArrayList<>();
	private final List<Round> rounds = new ArrayList<>();

	public RacingGame(String racers) {
		init(extractRacers(racers));
	}

	private List<String> extractRacers(String racers) {
		return new ArrayList<>(Arrays.asList(racers.split(",")));
	}

	private void init(List<String> racers) {
		cars.addAll(
			racers.stream()
				.map(r -> new Car(r, START_LOCATION))
				.collect(Collectors.toList())
		);
	}

	public void playRounds(int totalRound, MoveStrategy strategy) {
		for (int i = 0; i < totalRound; i++) {
			play(strategy);
		}
	}

	public void play(MoveStrategy strategy) {
		for (Car car : cars) {
			car.move(strategy.move());
		}
		rounds.add(new Round(clone(cars)));
	}

	private List<Car> clone(List<Car> cars) {
		List<Car> clone = new ArrayList<>();
		for (Car car : cars) {
			clone.add(new Car(car.getName(), car.getLocation()));
		}
		return clone;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}

	public List<Car> getWinners() {
		int maxScore = cars.stream()
			.mapToInt(Car::getLocation)
			.max().orElse(0);

		return cars.stream()
			.filter(c -> c.getLocation() == maxScore)
			.collect(Collectors.toList());
	}
}
