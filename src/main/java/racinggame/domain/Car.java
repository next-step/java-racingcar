package racinggame.domain;

public class Car {

	private int position;

	public Car() {
		position = 0;
	}

	public int move(int randomPosition) {
		if(!canMove(randomPosition)) {
			return position;
		}
		return position += randomPosition;
	}

	public boolean canMove(int randomPosition) {
		return randomPosition >= 4;
	}

	public int getCurrentPosition() {
		return position;
	}
}
