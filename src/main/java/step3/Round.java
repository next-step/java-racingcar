package step3;

import java.util.List;
import java.util.Random;

public class Round {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_LIMIT = 9;

	public static void play(List<Car> cars) {
		for (Car car : cars) {
			car.moveForward(getRandomNumber());
			ResultView.saveRoundScore(car);
		}
		ResultView.setNextRound();
	}

	private static int getRandomNumber() {
		return RANDOM.nextInt(RANDOM_LIMIT);
	}

}
