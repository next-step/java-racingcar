package racing.car;

public class Car {

	private final int MOVE_BOUND;
	private final int MOVE_INTERVAL;

	private final CarName name;
	private int position;

	public Car(int bound, int interval, int position, CarName name) {
		this.MOVE_BOUND = bound;
		this.MOVE_INTERVAL = interval;
		this.position = position;
		this.name = name;
	}

	public void move(int bound) {
		if (bound >= MOVE_BOUND)
			this.position += MOVE_INTERVAL;
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position;
	}

}
