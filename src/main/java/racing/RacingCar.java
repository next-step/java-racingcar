package racing;

import java.util.Random;

public class RacingCar {

	private static final int RACING_RANDOM_BOUND = 10;
	private static final int RACING_INCREASE_BOUND = 3;
	private static final int RACING_START_LOCATION = 1;
	private static final Random randomNumberMaker = new Random();

	private int location;

	public RacingCar() {

		this.location = RACING_START_LOCATION;
	}

	public int racing() {

		if (randomNumberMaker.nextInt(RACING_RANDOM_BOUND) > RACING_INCREASE_BOUND) {
			this.location++;
		}

		return this.location;
	}
}
