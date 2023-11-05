package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
	private static final int START_LOCATION = 1;
	private static final int STANDARD_SHUFFLE_NUM = 4;
	private static final List<Integer> NUM_BOX = List.of(0,1,2,3,4,5,6,7,8,9);
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
		Collections.shuffle(NUM_BOX);
		return NUM_BOX.iterator().next();
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Round> getRounds() {
		return rounds;
	}
}
