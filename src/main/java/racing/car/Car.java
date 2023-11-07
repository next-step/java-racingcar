package racing.car;

public class Car {

	private static final int MOVE_BOUND = 4;
	private static final int MOVE_INTERVAL = 1;
	private static final int INIT_POSITION = 0;

	private int id;
	private int position;

	public Car() {
		this.position = INIT_POSITION;
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
