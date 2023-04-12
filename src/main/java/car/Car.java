package car;

import java.util.Random;

public class Car {

	public static final int MINIMUM_RANDOM_VALUE = 0;
	public static final int MAXIMUM_RANDOM_VALUE = 9;
	public static final int MINIMUM_VALUE_TO_FORWARD = 4;
	public static final int MOVE_COUNT = 1;
	private static final Random RANDOM = new Random();
	private final String name;
	private int location;

	public Car(String name, int location) {
		this.name = name;
		this.location = location;
	}

	public int randomInt() {
		return RANDOM.nextInt(MAXIMUM_RANDOM_VALUE + 1);
	}

	public void move(int randomValue) {
		if (randomValue >= MINIMUM_VALUE_TO_FORWARD) {
			this.location += MOVE_COUNT;
		}
	}

	public String getName() {
		return this.name;
	}

	public int currentLocation() {
		return this.location;
	}
}
