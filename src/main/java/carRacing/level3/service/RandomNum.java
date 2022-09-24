package carRacing.level3.service;

import java.util.Random;

public class RandomNum {

	private static final Integer BOUNDARY = 10;

	public static int randomNum() {
		Random random = new Random();
		return random.nextInt(BOUNDARY);
	}
}
