package racing.car;

public class Car {

	private final int MOVE_BOUND;
	private final int MOVE_INTERVAL;

	private final CarName carName;
	private int position;

	public Car(int bound, int interval, int position, CarName carName) {
		this.MOVE_BOUND = bound;
		this.MOVE_INTERVAL = interval;
		this.position = position;
		this.carName = carName;
	}

	public void move(int bound) {
		if (bound >= MOVE_BOUND)
			this.position += MOVE_INTERVAL;
	}

	public int getMOVE_BOUND() {
		return MOVE_BOUND;
	}

	public int getMOVE_INTERVAL() {
		return MOVE_INTERVAL;
	}

	public CarName getCarName() {
		return carName;
	}

	public int getPosition() {
		return position;
	}
}
