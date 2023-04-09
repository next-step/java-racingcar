package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

	public static final int MINIMUM_RANDOM_VALUE = 0;
	public static final int MAXIMUM_RANDOM_VALUE = 9;
	public static final int MINIMUM_VALUE_TO_FORWARD = 4;
	public static final int MOVE_COUNT = 1;

	private static final Random RANDOM = new Random();

	private int location;

	public static List<Car> cars() {
		return new ArrayList<>();
	}

	public static void addCar(List<Car> cars) {
		cars.add(new Car());
	}

	public static void moveCars(List<Car> cars) {
		for (Car car : cars) {
			car.move(randomInt());
		}
	}

	public static int randomInt() {
		return RANDOM.nextInt(MAXIMUM_RANDOM_VALUE + 1);
	}

	public void move(int randomValue) {
		if (randomValue >= MINIMUM_VALUE_TO_FORWARD) {
			this.location += MOVE_COUNT;
		}
	}

	public int currentLocation() {
		return this.location;
	}
}
