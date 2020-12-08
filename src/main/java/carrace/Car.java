package carrace;

public class Car {
	private int position = 1;

	public int getPosition() {
		return position;
	}

	public int move(int step) {
		position += checkMovePossible(step);
		return position;
	}

	private int checkMovePossible(int randomNumber) {
		if (randomNumber < 4) {
			return 0;
		}
		return randomNumber;
	}
}
