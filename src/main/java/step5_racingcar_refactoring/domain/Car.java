package step5_racingcar_refactoring.domain;

import step5_racingcar_refactoring.service.RandomUtil;

public class Car {
	private static final int RULE_FORWARD = 4;
	private static final int RULE_MAX_RANGE = 9;
	private RandomUtil randomUtil;
	private CarName carName;
	private int position;

	public Car(Car car) {
		this.carName = car.carName;
		this.position = car.position;
		this.randomUtil = car.randomUtil;
	}

	public Car(String name, int position, RandomUtil randomUtil) {
		this.carName = new CarName(name);
		this.position = position;
		this.randomUtil = randomUtil;
	}

	public void tryMove() {
		if (isMovable()) {
			move();
		}
	}

	private boolean isMovable() {
		return RULE_FORWARD < randomUtil.randomNumber(RULE_MAX_RANGE);
	}

	private void move() {
		position++;
	}

	public String getName() {
		return carName.getCarName();
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"randomUtil=" + randomUtil +
			", name='" + carName + '\'' +
			", position=" + position +
			'}';
	}
}
