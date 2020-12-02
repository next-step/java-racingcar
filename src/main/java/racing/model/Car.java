package racing.model;

public class Car {
	private int id;
	private int forwardCount;

	public Car() {
	}

	public Car(int id, int forwardCount) {
		this.id = id;
		this.forwardCount = forwardCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public void setForwardCount(int forwardCount) {
		this.forwardCount = forwardCount;
	}

	public void forward() {
		this.forwardCount += 1;
	}
}
