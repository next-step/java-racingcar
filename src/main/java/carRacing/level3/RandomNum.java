package carRacing.level3;

import java.util.Random;

public class RandomNum {

	private static final Integer BOUNDARY = 10;
	private static final Integer PIVOT = 4;

	public static int randomNum() {
		Random random = new Random();
		return random.nextInt(BOUNDARY);
	}

	public static Boolean isMovable(int randomNum) {
		if (randomNum >= PIVOT && randomNum < BOUNDARY) {
			return true;
		}
		return false;
	}

}
