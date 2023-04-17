package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
	public static final int ZERO = 0;

	public static final int MAX_POWER = 10;

	public static final int POWER_THRESHOLD = 4;

	private final Random random;

	private final List<Distance> distanceList;

	private int power;

	public Car(Random random, List<Distance> distanceList, int power) {
		this.random = random;
		this.distanceList = distanceList;
		this.power = power;
	}

	public static Car create(int power) {
		Random random = new Random();
		List<Distance> distanceList = new ArrayList<>();

		return new Car(random, distanceList, power);
	}

	public static Car create() {
		Random random = new Random();
		List<Distance> distanceList = new ArrayList<>();

		return new Car(random, distanceList, ZERO);
	}

	public List<Distance> getDistanceList() {
		return distanceList;
	}

	public String getDistanceView() {
		return Distance.convertDistanceToView(distanceList);
	}

	public void drive() {
		startEngine();
		accelerate();
	}

	public void accelerate() {
		if (power < POWER_THRESHOLD) {
			return;
		}

		distanceList.add(Distance.create());
	}

	public void startEngine() {
		power = random.nextInt(MAX_POWER);
	}
}
