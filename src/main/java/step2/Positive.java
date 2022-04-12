package step2;

public class Positive {

	private final int value;

	public Positive(String text) {
		this(Integer.parseInt(text));
	}

	public Positive(int value) {
		throwIfValueIsNegative(value);
		this.value = value;
	}

	private void throwIfValueIsNegative(int number) {
		if (number < 0) {
			throw new RuntimeException("음수입니다.");
		}
	}

	public int toResult() {
		return this.value;
	}

	public Positive add(Positive operand) {
		int result = this.value + operand.value;
		return new Positive(result);
	}

}
