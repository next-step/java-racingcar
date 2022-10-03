package racingcar;

import java.util.Random;

public class Car {
	private static int MAXOFRANDOM = 10;
	private static final int MOVINGCONDITION = 4;
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}

	public void movingOfRound(int random) {
		if (random >= MOVINGCONDITION) {
			this.position = new Position(this.position.getPosition() + 1);
		}
	}

	public int makeRandom() {
		return new Random().nextInt(MAXOFRANDOM);
	}

	public int getStatus() {
		return this.position.getPosition();
	}

	public String getName() {
		return this.name;
	}
}
