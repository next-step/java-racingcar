package racingcar;

public class Car {
	private static final int MIN_MOVE_VALUE = 4;
	private int distance;

	public Car() {
		distance = 0;
	}

	public void go() {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		if (randomNumber >= MIN_MOVE_VALUE) {
			distance++;
		}
		OutputView.printCarDistance(distance);
	}

	public int getDistance() {
		return distance;
	}
}
