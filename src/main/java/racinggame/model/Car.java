package racinggame.model;

public class Car {
	private int status;
	private static final int DEFAULT_STATUS = 0;

	public Car() {
		this.status = DEFAULT_STATUS;
	}

	public Car move() {
		status = status + 1;
		return this;
	}

	public int getStatus() {
		return status;
	}
}
