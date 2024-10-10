package step4.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import step4.domain.movestrategy.CarMoveStrategy;
import step4.domain.movestrategy.DefaultRandomMoveStrategy;

public class Car {
	public static int DEFAULT_SPEED = 1;
	private final String name;
	private final List<Integer> carPositionHistory = new ArrayList<>();
	private int currentPosition;
	private CarMoveStrategy moveStrategy;

	public Car(String name) {
		this.currentPosition = 0;
		this.moveStrategy = new DefaultRandomMoveStrategy(new Random()); // 기본 전략 지정
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void move(boolean movable) {
		if (movable) {
			currentPosition += moveStrategy.speed();
		}
		carPositionHistory.add(currentPosition);
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public CarMoveStrategy getMoveStrategy() {
		return moveStrategy;
	}

	public void setMoveStrategy(CarMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public List<Integer> getCarPositionHistory() {
		return carPositionHistory;
	}
}
