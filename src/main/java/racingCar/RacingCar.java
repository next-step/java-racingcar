package racingCar;

import java.util.Random;

public class RacingCar {
	public static int getRandomNumber() {
		return new Random().nextInt(10);
	}

	public static boolean canMove(int randomNumber) {
		if (randomNumber > 3) {
			return true;
		}
		return false;
	}
}
