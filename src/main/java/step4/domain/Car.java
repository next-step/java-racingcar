package step4.domain;

import java.util.Random;

public class Car {
	public static int DEFAULT_SPEED = 1;
	public static int STOP_SPEED = 0;

	private int position;
	private CarMoveStrategy moveStrategy;

	public Car() {
		this.position = 0;
		this.moveStrategy = new DefaultRandomMoveStrategy(new Random()); // 기본 전략 지정
	}

	public void move(boolean movable) {
		if (movable) {
			position += moveStrategy.speed();
		}
	}

	public int getPosition() {
		return position;
	}

	public CarMoveStrategy getMoveStrategy() {
		return moveStrategy;
	}

	public void setMoveStrategy(CarMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
}
