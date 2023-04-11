package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
	public static final int ZERO = 0;

	public static final int MAX_SPEED = 10;

	private final Random random;

	private final List<Distance> distanceList;

	private int speed;

	public Car(int speed, Random random, List<Distance> distanceList) {
		this.speed = speed;
		this.random = random;
		this.distanceList = distanceList;
	}

	public static Car create() {
		Random random = new Random();
		List<Distance> mileageList = new ArrayList<>();

		return new Car(ZERO, random, mileageList);
	}

	public void stop() {
		speed = ZERO;
	}

	public void drive() {
		// 일정 시간 주행했다고 가정한다
		distanceList.addAll(Distance.from(speed));
	}

	public List<Distance> getDistanceList() {
		return distanceList;
	}

	public int getSpeed() {
		return speed;
	}

	public String getMileageView() {
		return Distance.convertDistanceToView(distanceList);
	}

	public void accelerate(int speed) {
		this.speed = speed;
	}

	public void accelerate() {
		// 자동차의 속력은 밟을 때마다 랜덤이다
		int speed = random.nextInt(MAX_SPEED);

		this.speed = speed;
	}
}
