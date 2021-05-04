package domain;

import java.util.Random;

public class Racingcar {
	private static final int MOVE_OR_NOT_DETERMINANT = 3;
	private static final int MAX_RANDOM_VALUE = 10;

	private final String carName;
	private String carPosition;

	public Racingcar(String carName) {
		this(carName, "");
	}

	public Racingcar(String carName, String carPosition) {
		this.carName = carName;
		this.carPosition = carPosition;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarPosition() {
		return carPosition;
	}

	public void setPosition() {
		Random random = new Random();
		int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
		this.carPosition += moveForwardOrNot(randomNumber);
	}

	public static String moveForwardOrNot(int randomValue) {
		if (randomValue > MOVE_OR_NOT_DETERMINANT) {
			return "-";
		}
		return "";
	}
}
