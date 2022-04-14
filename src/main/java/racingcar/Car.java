package racingcar;

import java.util.Random;

public class Car {
	public static final int LIMIT_RANDOM_NUMBER = 10;
	public static final int MOVE_CONDITION = 4;
	public static final String movingUnit = "-";
	private String status = "";
	private int valueToMovable;

	private void randomNumber() {
		Random random = new Random();
		int number = random.nextInt(LIMIT_RANDOM_NUMBER);
		this.valueToMovable = number;
	}

	public void move() {
		if (isMovable()) {
			status += movingUnit;
		}

		status += "";
	}

	public boolean isMovable() {
		randomNumber();

		if (this.valueToMovable >= MOVE_CONDITION) {
			return true;
		}

		return false;
	}

	public String carStatus() {
		return status;
	}

	public int getValueToMovable() {
		return valueToMovable;
	}
}
