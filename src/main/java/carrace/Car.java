package carrace;

public class Car {
	private int position;

	public int getPosition() {
		return position;
	}

	public void move(int step) {
		this.position += checkMovePossible(step);
	}

	private int checkMovePossible(int randomNumber) {
		if (randomNumber < 4) {
			return 0;
		}
		return randomNumber;
	}
}
