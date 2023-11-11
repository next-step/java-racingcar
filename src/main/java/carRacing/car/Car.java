package carRacing.car;

import carRacing.moveStrategy.MoveStrategy;

public class Car {

	private int position;
	private String name;

	public Car() {
		this(0,"");
	}

	public Car(String name) {
		this(0, name);
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
	public String getName() {
		return name;
	}
}
