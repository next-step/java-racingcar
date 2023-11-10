package carRacing.car;

import carRacing.moveStrategy.MoveStrategy;

public class Car {

	private static final int MINIMUM_TO_MOVE = 4;

	private int position;
	private String name;

	public Car() {
	}

	public Car(String name) {
		this.position = position;
		this.name = name;
	}

	public Car(int position, String name) {
		this.position = position;
		this.name = name;
	}

	public void moveCar(MoveStrategy moveStrategy) {
		if (moveStrategy.isForward()) {
			position++;
		}
	}

	public boolean isSamePosition(int maxPosition) {
		return maxPosition == this.position;
	}

	public int maxPosition(int maxPosition) {
		if (this.position > maxPosition) {
			return this.position;
		}
		return maxPosition;
	}

	public String getName() {
		return name;
	}
}
