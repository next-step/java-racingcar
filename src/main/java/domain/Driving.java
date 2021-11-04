package domain;

import java.util.Random;

public class Driving {
	private static final int RANDOM_NUMBER_MAX = 10;
	private static final Random random = new Random();

	public Driving() {
	}

	public static int drive() {
		return random.nextInt(RANDOM_NUMBER_MAX);
	}
}
