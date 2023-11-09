package carRacing.numberMaker;

import java.util.Random;

public class RandomNumberMaker implements NumberMaker {

	private static final int MAXIMUM_BOUND = 10;

	private Random random = new Random();

	@Override
	public int makeNumber() {
		return random.nextInt(MAXIMUM_BOUND);
	}
}
