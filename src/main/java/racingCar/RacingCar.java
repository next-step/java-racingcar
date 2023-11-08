package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
	public static int getRandomNumber() {
		return new Random().nextInt(10);
	}

	public static boolean canMove(int randomNumber) {
		return randomNumber > 3;
	}

	public static List<Car> getCarList(int carCount) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car());
		}
		return carList;
	}
		}
		return false;
	}
}
