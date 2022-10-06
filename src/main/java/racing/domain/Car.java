package racing.domain;

public class Car {

	private final static int START_POINT = 1;
	private final static int MOVE_PIVOT = 4;

	private final RandomNumber randomNumber;
	private int location;

	public Car(RandomNumber randomNumber) {
		this(START_POINT, randomNumber);
	}

	public Car(int location, RandomNumber randomNumber) {
		this.location = location;
		this.randomNumber = randomNumber;
	}

	public int move() {
		if (isMovable(randomNumber.getRandomNumber())) {
			moveForward();
			return 1;
		}
		return 0;
	}

	private boolean isMovable(int randomNumber) {
		return randomNumber >= MOVE_PIVOT;
	}

	private void moveForward() {
		this.location += 1;
	}

	public int getLocation() {
		return location;
	}

	public RandomNumber getRandomNumber() {
		return randomNumber;
	}
}
