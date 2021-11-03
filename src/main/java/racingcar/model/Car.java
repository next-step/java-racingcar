package racingcar.model;

import racingcar.generator.Generator;

public class Car {
	private static final int MOVING_CONDITION = 4;

	private final Position position;

	private Car() {
		this(Position.create());
	}

	private Car(Position position) {
		this.position = position;
	}

	public static Car create() {
		return new Car();
	}

	public void move(Generator generator) {
		if (canMove(generator)) {
			position.increase();
		}
	}

	private boolean canMove(Generator generator) {
		return generator.generate() > MOVING_CONDITION;
	}

	@Override
	public String toString() {
		return position.convertPositionToDash();
	}
}
