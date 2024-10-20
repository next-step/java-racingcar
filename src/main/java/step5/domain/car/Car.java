package step5.domain.car;

import java.util.Random;

import step5.domain.movestrategy.CarMoveStrategy;
import step5.domain.movestrategy.RandomMoveStrategy;

public class Car {
	private static final CarMoveStrategy DEFAULT_MOVE_STRATEGY = new RandomMoveStrategy(new Random());

	private final String name;
	private final int speed;
	private final CarMoveStrategy moveStrategy;
	private final Position position;

	public Car(String name, CarMoveStrategy moveStrategy, int speed) {
		this.position = new Position(0);
		this.moveStrategy = getCheckedMoveStrategy(moveStrategy);
		this.name = getCheckedName(name);
		this.speed = getCheckedSpeed(speed);
	}

	private static int getCheckedSpeed(int speed) {
		if (speed < 0) {
			throw new IllegalArgumentException("Car의 Speed는 자연수 값이어야만 합니다.");
		}
		return speed;
	}

	private static String getCheckedName(String name) {
		if (name == null) {
			throw new NullPointerException("자동차는 이름을 꼭 입력해야 합니다.");
		}
		return name;
	}

	private static CarMoveStrategy getCheckedMoveStrategy(CarMoveStrategy moveStrategy) {
		if (moveStrategy == null) {
			return DEFAULT_MOVE_STRATEGY;
		}
		return moveStrategy;
	}

	public static CarBuilder builder() {
		return new CarBuilder();
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public void move() {
		if (moveStrategy.movable()) {
			position.addPositionBySpeed(this.speed);
		}
	}

	public static class CarBuilder {
		private static final int DEFAULT_SPEED = 1;

		private String name;
		private int speed = DEFAULT_SPEED;
		private CarMoveStrategy moveStrategy;

		public CarBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public CarBuilder setSpeed(int speed) {
			this.speed = speed;
			return this;
		}

		public CarBuilder setStrategy(CarMoveStrategy strategy) {
			this.moveStrategy = strategy;
			return this;
		}

		public Car build() {
			return new Car(name, moveStrategy, speed);
		}
	}
}

