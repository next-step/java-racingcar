package study;

import java.util.Random;

public class NumberContainer {

	private Random numberGenerator;
	private static int NUMBER_RANGE = 10;

	public NumberContainer() {
		numberGenerator = new Random();
	}

	public int getRandomNumber() {
		return numberGenerator.nextInt(NUMBER_RANGE);
	}
}
