package carRacing.level3.model.strategy;

import java.util.Random;

public class RandomNum {

	private static final int BOUNDARY = 10;

	public int randomNum() {
		Random random = new Random();
		return random.nextInt(BOUNDARY);
	}

}
