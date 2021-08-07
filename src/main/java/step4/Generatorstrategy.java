package step4;

import java.util.Random;

public class Generatorstrategy implements NumberGenerator {

	private static int NUMBER_RANGE = 10;

	private Random random;

	public Generatorstrategy() {
		this.random = new Random();
	}

	@Override
	public int getNumber() {
		return random.nextInt(NUMBER_RANGE);
	}
}
