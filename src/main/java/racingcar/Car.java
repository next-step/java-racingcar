package racingcar;

public class Car {

	public static final int MIN_MOVE_NUMBER = 0;
	public static final int MAX_MOVE_NUMBER = 9;
	public static final int MOVE_THRESHOLD = 4;

	public int position;

	public Car() {
		this.position = 0;
	}

	public int getPosition() {
		return position;
	}

	public String move(int number) {
		validate(number);

		if (number < MOVE_THRESHOLD) {
			return "-".repeat(position);
		}

		return "-".repeat(++position);
	}

	private static void validate(int number) {
		if (number < MIN_MOVE_NUMBER || number > MAX_MOVE_NUMBER) {
			throw new IllegalArgumentException("0부터 9까지의 숫자만 입력할 수 있습니다.");
		}
	}
}
