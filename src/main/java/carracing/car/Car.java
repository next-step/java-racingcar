package carracing.car;

public class Car {
	private static final int MOVING_DISTANCE = 1;
	private int movingDistance;

	public Car() {
		this(0);
	}

	public Car(int movingDistance) {
		this.movingDistance = movingDistance;
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isPossible()) {
			moveDistance();
		}
	}

	private void moveDistance() {
		this.movingDistance += MOVING_DISTANCE;
	}

	public int movingDistance() {
		return this.movingDistance;
	}
}
