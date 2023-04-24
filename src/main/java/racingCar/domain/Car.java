package racingCar.domain;

import java.util.Random;

public class Car {
	public static final int ZERO = 0;

	public static final int MAX_POWER = 10;

	public static final int POWER_THRESHOLD = 4;

	private final Random random = new Random();

	private final String name;

	private final Distance distance;

	private int power;

	public int getDistanceAmount() {
		return distance.getAmount();
	}

	public Car(String name, int power, Distance distance) {
		this.name = name;
		this.power = power;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public static Car of(String name, int power) {
		Distance distance = Distance.create();

		return new Car(name, power, distance);
	}

	public static Car from(String name) {
		Distance distance = Distance.create();

		return new Car(name, ZERO, distance);
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
