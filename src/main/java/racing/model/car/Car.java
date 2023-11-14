package racing.model.car;

public class Car {

	private final int MOVE_BOUND;
	private final int MOVE_INTERVAL;

	private final CarName carName;
	private final Position position;

	public Car(int bound, int interval, Position position, CarName carName) {
		this.MOVE_BOUND = bound;
		this.MOVE_INTERVAL = interval;
		this.position = position;
		this.carName = carName;
	}

	public Position position() {
		return this.position;
	}

	public String name() {
		return carName.name();
	}

	public Car deepCopy() {
		return new Car(MOVE_BOUND, MOVE_INTERVAL, position.deepCopy(), carName.deepCopy());
	}

	public void move(int bound) {
		if (bound >= MOVE_BOUND)
			this.position.move();
	}

}
