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

	private final List<Car> CARS = new ArrayList<>();

	public void addCar() {
		this.CARS.add(new Car());
	}

	public void moveCars() {
		for (Car car : this.CARS) {
			car.move(randomInt());
		}
	}

	public int randomInt() {
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

	public List<Car> getCars() {
		return this.CARS;
	}
}
