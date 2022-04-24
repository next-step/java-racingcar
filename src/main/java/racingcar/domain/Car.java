package racingcar.domain;

import racingcar.util.generator.NumberGenerator;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.strategy.move.CarMoveStrategy;
import racingcar.util.strategy.move.MoveStrategy;

public class Car {
	private NumberGenerator numberGenerator;
	private MoveStrategy moveStrategy;
	private Name name;
	private Position position;

	public Car(String name) {
		this(new RandomNumberGenerator(), new CarMoveStrategy());
		this.name = new Name(name);
		this.position = new Position("");
	}

	public Car(String name, String position) {
		this(new RandomNumberGenerator(), new CarMoveStrategy());
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public Car(NumberGenerator numberGenerator, MoveStrategy moveStrategy) {
		this.numberGenerator = numberGenerator;
		this.moveStrategy = moveStrategy;
		this.name = new Name("car");
		this.position = new Position("");
	}

	public void move() {
		if (isMovable(generateValueToMove())) {
			position.forward(Position.MOVING_UNIT);
		}
	}

	public boolean isMovable(int number) {
		return moveStrategy.isMovable(number);
	}

	public String name() {
		return this.name.showName();
	}

	public String carStatus() {
		return position.show();
	}

	private int generateValueToMove() {
		return this.numberGenerator.generate();
	}
}
