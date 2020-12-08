package racingcar.domain;

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

	public void tryMove(int randomNumber) {
		if (randomNumber >= STANDARD_TO_MOVE) {
			this.move();
		}
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
