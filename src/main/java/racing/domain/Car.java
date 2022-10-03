package racing.domain;

public class Car {

	private final static int START_POINT = 1;
	private final static int MOVE_PIVOT = 4;
	private int location;
	private RandomNumber randomNumber;

	public Car(RandomNumber randomNumber) {
		this(START_POINT, randomNumber);
	}

	public Car(int location, RandomNumber randomNumber) {
		this.location = location;
		this.randomNumber = randomNumber;
	}

	public void move() {
		if (isMovable(randomNumber.getRandomNumber())) {
			moveForward();
		}
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
}
