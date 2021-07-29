package carrase;

import java.util.Random;

public class CarUtil {
	public static int makeRadomNumber() {
		Random random = new Random();

		return random.nextInt(10);
	}
}
