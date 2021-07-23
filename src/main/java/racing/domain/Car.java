package racing.domain;

public class Car {

	private int move;

	public Car() {
		this.move = 0;
	}

	public void move(int randomValue, int compareValue) {
		if (randomValue >= compareValue) {
			this.move++;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < this.move; i++) {
			builder.append('-');
		}

		return builder.toString();
	}
}
