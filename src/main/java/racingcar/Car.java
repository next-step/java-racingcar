package racingcar;

import org.apache.commons.lang3.StringUtils;

public class Car {
	private String name;
	private int moveCount = 0;
	private static final int STANDARD_TO_MOVE = 4;

	public Car(String name) {
		if (!validateName(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public int tryMove(int randomNumber) {
		if (randomNumber >= STANDARD_TO_MOVE) {
			this.move();
		}
		return this.moveCount;
	}

	public RacingResult racingResult() {
		return new RacingResult(this.name, this.moveCount);
	}

	private void move() {
		this.moveCount++;
	}

	private boolean validateName(String name) {
		return !StringUtils.isEmpty(name) && name.length() <= 5;
	}
}
