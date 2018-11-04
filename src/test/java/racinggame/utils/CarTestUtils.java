package racinggame.utils;

import racinggame.domain.Car;

public class CarTestUtils {

	public static Car move(Car car, int times) {
		final int ALLWAYS_MOVE_NUMBER = 4;
		for(int time = 0; time < times; time++) {
			car.move(ALLWAYS_MOVE_NUMBER);
		}
		return car;
	}
}
