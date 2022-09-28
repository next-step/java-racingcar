package racingcar.step3_4;

public class Car {

	private static final int INITIAL_POSITION = 0;
	private static final int MIN_MOVE_VALUE = 4;

	private int position;

	public Car() {
		this(INITIAL_POSITION);
	}

	public Car(int position) {
		this.position = position;
	}

	public int move(RandomValueGenerator randomValueGenerator) {
		if (randomValueGenerator.generate() >= MIN_MOVE_VALUE) {
			this.position++;
		}

		return position;
	}

	public int getPosition() {
		return position;
	}
}
