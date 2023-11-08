package racing.car;

public class Car {

	private final int MOVE_BOUND;
	private final int MOVE_INTERVAL;

	private int id;
	private int position;

	public Car(int bound, int interval, int position) {
		this.MOVE_BOUND = bound;
		this.MOVE_INTERVAL = interval;
		this.position = position;
	}

	public void move(int bound) {
		if (bound >= MOVE_BOUND)
			this.position += MOVE_INTERVAL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
