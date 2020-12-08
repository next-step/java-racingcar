package carrace;

public class Car {
	private int position;

	public int getPosition() {
		return position;
	}

	public void move(int step) {
		this.position += step;
	}
}
