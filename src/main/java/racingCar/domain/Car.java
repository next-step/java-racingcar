package racingCar.domain;

import java.util.Random;

public class Car {
	public static final int ZERO = 0;

	public static final int MAX_POWER = 10;

	public static final int POWER_THRESHOLD = 4;

	private final Random random;

	private final Distance distance;

	private int power;

	public int getDistanceAmount() {
		return distance.getAmount();
	}

	public Car(Random random, Distance distance, int power) {
		this.random = random;
		this.distance = distance;
		this.power = power;
	}

	public static Car create(int power) {
		Random random = new Random();
		Distance distance = Distance.create();

		return new Car(random, distance, power);
	}

	public static Car create() {
		Random random = new Random();
		Distance distance = Distance.create();

		return new Car(random, distance, ZERO);
	}

	public void drive() {
		startEngine();
		accelerate();
	}

	public void accelerate() {
		if (power < POWER_THRESHOLD) {
			return;
		}

		distance.addDistance();
	}

	public void startEngine() {
		power = random.nextInt(MAX_POWER);
	}
}
