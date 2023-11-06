package racingcar;

public class Car {
	private int location;
	private final static int MOVABLE_LOWER_BOUND = 4;

	public Car(int location) {
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public void move(int random) {
		if (isOverLowerBound(random)) {
			moveForward();
		}
	}

	private void moveForward() {
		this.location++;
	}

	private boolean isOverLowerBound(int num) {
		return num >= MOVABLE_LOWER_BOUND;
	}
}
