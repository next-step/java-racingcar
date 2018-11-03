package racinggame.domain;

public class Car {

	public static final int MOVE_CONDITION = 4;

	private int position;

	public Car() {
		position = 0;
	}

	public int move(int randomNumber) {
		if(!canMove(randomNumber)) {
			return position;
		}
		return ++position;
	}

	public boolean canMove(int randomNumber) {
		return randomNumber >= MOVE_CONDITION;
	}

	public int getCurrentPosition() {
		return position;
	}
}
