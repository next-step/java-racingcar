package study4;

import java.util.Random;


public class RandomGenerator {

	private static int randomrange = 10;

	public int randomGenerate() {
		Random ran = new Random();
		int a = ran.nextInt(randomrange);
		return a;
	}
}
