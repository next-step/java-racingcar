package racing.domain;

public class Car {

	private final String name;
	private int move;

	private static final int COMPARE_VALUE = 4;

	public Car(String name) {
		this.name = name;
		this.move = 0;
	}

	public void move(int randomValue) {
		if (randomValue >= COMPARE_VALUE) {
			this.move++;
		}
	}

	public int getMove() {
		return move;
	}
}
