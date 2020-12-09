package racing.car;

public class Car {

	private final String carName;
	private final MoveForwardStrategy moveForwardStrategy;
	private int position;

	public Car(String carName, MoveForwardStrategy moveForwardStrategy) {
		this.carName = carName;
		this.moveForwardStrategy = moveForwardStrategy;
	}

	public void getMoveForwardChance() {
		if (this.moveForwardStrategy.isMovableChance()) {
			this.moveForward();
		}
	}

	public String getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}

	void moveForward() {
		this.position++;
	}
}
