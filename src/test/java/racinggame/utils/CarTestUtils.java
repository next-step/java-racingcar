package racinggame.utils;

import racinggame.domain.Car;

public class CarTestUtils {

	public static Car create(String name) {
		return new Car(name);
	}

	public static Car createAndMove(String name, int times) {
		return move(new Car(name), times);
	}

	public static Car move(Car car, int times) {
		final int ALLWAYS_MOVE_NUMBER = 4;
		for(int time = 0; time < times; time++) {
			car.move(ALLWAYS_MOVE_NUMBER);
		}
		return car;
	}
}
