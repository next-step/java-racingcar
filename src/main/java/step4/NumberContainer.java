package step4;

import java.util.Random;

public class NumberContainer {

	private static int NUMBER_RANGE = 10;

	private Random numberGenerator;

	public NumberContainer() {
		numberGenerator = new Random();
	}

	public int getRandomNumber() {
		return numberGenerator.nextInt(NUMBER_RANGE);
	}
}
