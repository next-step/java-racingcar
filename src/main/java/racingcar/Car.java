package racingcar;

public class Car {
	private int mileage;

	public Car(int mileage) {
		this.mileage = mileage;
	}

	public Car() {
		this(0);
	}

	public void move(RacingCarMoveStrategy strategy) {
		if (strategy.isMovable()) {
			this.mileage += 1;
		}
	}

	public int getMileage() {
		return this.mileage;
	}
}
