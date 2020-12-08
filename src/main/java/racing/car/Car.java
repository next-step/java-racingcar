package racing.car;

public class Car {

	private final MoveForwardStrategy moveForwardStrategy;
	private int position;

	public Car(MoveForwardStrategy moveForwardStrategy) {
		this.moveForwardStrategy = moveForwardStrategy;
		this.position = 0;
	}

	public void getMoveForwardChance() {
		if (this.moveForwardStrategy.isMovableChance()) {
			moveForward();
		}
	}

	public int getPosition() {
		return this.position;
	}

	void moveForward() {
		this.position++;
	}
}
