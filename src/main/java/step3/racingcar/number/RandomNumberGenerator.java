package step3.racingcar.number;

import java.util.Random;

public class RandomNumberGenerator {

	public int generate() {
		return new Random().nextInt(10);
	}
}
