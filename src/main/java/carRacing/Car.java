package carRacing;

public class Car {

	private static final int MINIMUM_TO_MOVE = 4;

	private int position;

	public void moveCar(int randomNum) {
		if (isCarFoward(randomNum)) {
			position++;
		}
	}

	public boolean isCarFoward(int num) {
		return num >= MINIMUM_TO_MOVE;
	}

	public int getPosition() {
		return position;
	}
}
