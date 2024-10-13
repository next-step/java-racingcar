package step4.domain.car;

import step4.domain.movestrategy.CarMoveStrategy;

public class Car {
	private final String name;
	private final int speed;
	private int position;
	private CarMoveStrategy moveStrategy;

	public Car(String name, CarMoveStrategy moveStrategy, int speed) {
		this.position = 0;
		this.setMoveStrategy(moveStrategy);
		this.name = name;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move() {
		if (moveStrategy.movable()) {
			position += this.speed;
		}
	}

	private void setMoveStrategy(CarMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
}
