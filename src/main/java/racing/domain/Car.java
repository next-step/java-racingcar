package racing.domain;

public class Car {

	private final static int START_POINT = 1;
	private final static int MOVE_PIVOT = 4;

	private final RandomNum randomNum;
	private int location;

	public Car(RandomNum randomNum) {
		this(START_POINT, randomNum);
	}

	public Car(int location, RandomNum randomNum) {
		this.location = location;
		this.randomNum = randomNum;
	}

	public int move() {
		if (isMovable(randomNum.getRandomNumber())) {
			moveForward();
			return 1;
		}
		return 0;
	}

	private boolean isMovable(int randomNum) {
		return randomNum >= MOVE_PIVOT;
	}

	private void moveForward() {
		this.location += 1;
	}

	public int getLocation() {
		return location;
	}
}
