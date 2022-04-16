package racingcar.domain;

import racingcar.util.generator.NumberGenerator;
import racingcar.util.strategy.move.MoveStrategy;

public class Car {
	public static final String MOVING_UNIT = "-";
	private NumberGenerator numberGenerator;
	private MoveStrategy moveStrategy;
	private int value;
	private String status = "";

	public Car(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public Car(NumberGenerator numberGenerator, MoveStrategy moveStrategy) {
		this.numberGenerator = numberGenerator;
		this.moveStrategy = moveStrategy;
	}

	public void move() {
		this.value = getNumber();

		if (isMovable(value)) {
			status += MOVING_UNIT;
		}

		status += "";
	}

	public boolean isMovable(int number) {
		return moveStrategy.isMovable(number);
	}

	public String carStatus() {
		return status;
	}

	private int getNumber() {
		return this.numberGenerator.generate();
	}
}
