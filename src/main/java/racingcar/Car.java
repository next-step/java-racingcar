package racingcar;

import java.util.Random;

public class Car extends Condition{
	private static int MAX_OF_RANDOM = 10;
	private static final int MOVING_CONDITION = 4;
	private String name;
	private Position position;

	public Car(String name) {
		super(new NameCondition());
		if (validInput(name)) {
			throw new RuntimeException();
		}
		this.name = name;
		this.position = new Position();
	}

	public void movingOfRound(int random) {
		if (random >= MOVING_CONDITION) {
			this.position = new Position(this.position.getPosition() + 1);
		}
	}

	public int makeRandom() {
		return new Random().nextInt(MAX_OF_RANDOM);
	}

	public int getStatus() {
		return this.position.getPosition();
	}

	public String getName() {
		return this.name;
	}
}
