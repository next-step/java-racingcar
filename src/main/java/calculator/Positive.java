package calculator;

public class Positive {

	private int number;

	public Positive(String value) {
		this(Integer.parseInt(value));
	}

	public Positive(int value) {
		if (isNegative(value)) {
			throw new NumberFormatException("유효하지 않는 숫자 포맷(음수)입니다.");
		}
		this.number = value;
	}

	private boolean isNegative(int number) {
		return number < 0;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Positive{" +
			"number=" + number +
			'}';
	}
}
