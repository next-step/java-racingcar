package racingCar.util;

import java.util.Random;

public class RandomNumberSupplier implements NumberSupplier{
	@Override
	public int get() {
		return new Random().nextInt(10);
	}
}
