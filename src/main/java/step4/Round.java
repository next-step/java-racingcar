package step4;

import java.util.Random;

public class Round {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_LIMIT = 9;

	public static Cars play(Cars participants) {
		for (Car car : participants.getRacingCars()) {
			car.moveForward(getRandomNumber());
		}
		return participants;
	}

	private static int getRandomNumber() {
		return RANDOM.nextInt(RANDOM_LIMIT);
	}

}
