package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
	private static final int START_LOCATION = 0;
	private final List<Car> cars = new ArrayList<>();
	private final List<Round> rounds = new ArrayList<>();

	public RacingGame(Integer totalCarSum) {
		init(totalCarSum);
	}

	private void init(Integer totalCarSum) {
		for (int i = 0; i < totalCarSum; i++) {
			cars.add(new Car(START_LOCATION));
		}
	}

	public void playRounds(int totalRound) {
		for (int i = 0; i < totalRound; i++) {
			play();
		}
	}

	private void play() {
		for (Car car : cars) {
			if (isOverNum()) {
				car.moveForward();
			}
		}
		rounds.add(new Round(clone(cars)));
	}

	private boolean isOverNum() {
		return shuffleNumBox() >= STANDARD_SHUFFLE_NUM;
	}

	private List<Car> clone(List<Car> cars) {
		List<Car> clone = new ArrayList<>();
		for (Car car : cars) {
			clone.add(new Car(car.getLocation()));
		}
		return clone;
	}

	private int shuffleNumBox() {
		return new Random().nextInt(10);
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Round> getRounds() {
		return rounds;
	}
}
