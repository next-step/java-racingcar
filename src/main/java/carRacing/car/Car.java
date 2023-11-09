package carRacing.car;

import carRacing.numberMaker.NumberMaker;

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

	public void moveCar(NumberMaker numberMaker) {
		if (isCarFoward(numberMaker.makeNumber())) {
			position++;
		}
	}

	private boolean isCarFoward(int num) {
		return num >= MINIMUM_TO_MOVE;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
