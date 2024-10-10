package step4.domain.car;

import java.util.Random;

import step4.domain.movestrategy.CarMoveStrategy;
import step4.domain.movestrategy.DefaultRandomMoveStrategy;

public class Car {
	public static int DEFAULT_SPEED = 1;
	public static int STOP_SPEED = 0;

	private int position;
	private CarMoveStrategy moveStrategy;
	private String name;

	public Car(String name) {
		this.position = 0;
		this.moveStrategy = new DefaultRandomMoveStrategy(new Random()); // 기본 전략 지정
		this.name = name;
	}

	public String getName() {
		return name;
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
