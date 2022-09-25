package racingcar;

import java.util.Random;

public class RandomNumber {

	public static final int BOUNDARY_OFFSET = 1;

	int generate(int boundInclusive) {
		Random random = new Random();
		return random.nextInt(boundInclusive + BOUNDARY_OFFSET);
	}
}
