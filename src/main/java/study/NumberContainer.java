package study;

import java.util.Random;

public class NumberContainer {

	private Random numberGenerator;

	public NumberContainer() {
		numberGenerator = new Random();
	}

	public int getRandomNumber() {
		return numberGenerator.nextInt(10);
	}
}
