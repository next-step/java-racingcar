package carRacing.domain;

import carRacing.strategy.MoveStrategy;

public class Car {

	private int position;
	private Name carName;

	public Car() {
		this(0, "");
	}

	public Car(String carName) {
		this(0, carName);
	}

	public Car(int position, String name) {
		this.position = position;
		this.carName = new Name(name);
	}

	public void moveCar(MoveStrategy moveStrategy) {
		if (moveStrategy.isForward()) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return position == this.position;
	}

	public int maxPosition(int maxPosition) {
		if (this.position > maxPosition) {
			return this.position;
		}
		return maxPosition;
	}

	public int getPosition() {
		return position;
	}

	public String getCarName() {
		return carName.toString();
	}
}
