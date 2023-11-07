package calculator;

public class PositiveNumber {
	private final Integer number;

	public PositiveNumber(Integer number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public boolean isPositive() {
		return number < 0;
	}
}
