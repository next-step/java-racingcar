package carRacing;

public class Car {

	private static final int MINIMUM_TO_MOVE = 4;

	private int position;
	private String name;

	public Car() {
	}

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(int randomNum) {
		if (isCarFoward(randomNum)) {
			position++;
		}
	}

	private boolean isCarFoward(int num) {
		return num >= MINIMUM_TO_MOVE;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
