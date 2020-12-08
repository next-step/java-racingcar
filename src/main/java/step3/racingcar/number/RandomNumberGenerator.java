package step3.racingcar.number;

import java.util.Random;

public class RandomNumberGenerator {

	public static int generate() {
		final int RANDOM_NUMBER_BOUNDARY = 10;
		return new Random().nextInt(RANDOM_NUMBER_BOUNDARY);
	}

}
