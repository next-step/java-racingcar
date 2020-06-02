package study4.domain;

import java.util.Random;

public class RandomGenerator {

	private static final int randomrange = 10;

	public int randomGenerate() {
		Random ran = new Random();
		return ran.nextInt(randomrange);
	}
}
