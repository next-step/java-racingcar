package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
	private static final int RANDOM_BOUND = 10;
	private static final int CONDITION_ADVANCE = 4;
	private final OutputView outputView = new OutputView();

	public void play(int[] answers) {
		int numberOfCars = answers[0];
		int numberOfTrials = answers[1];

		List<Car> cars = prepareCars(numberOfCars);

		for (int i = 0; i < numberOfTrials; i++) {
			gameByTrial(cars);
			outputView.viewEndTrial();
		}
	}

	private List<Car> prepareCars(int numberOfCars) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car());
		}
		return cars;
	}

	private void gameByTrial(List<Car> cars) {
		for (Car car : cars) {
			advanceOrStop(car);
			outputView.viewCarState(car);
		}
	}

	private void advanceOrStop(Car car) {
		if (isAdvance()) {
			car.advance();
			return;
		}
		car.stop();
	}

	private boolean isAdvance() {
		int value = new Random().nextInt(RANDOM_BOUND);
		return value >= CONDITION_ADVANCE;
	}
}
