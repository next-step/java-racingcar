package step2;

public class NonNegative {

	private final int value;

	public NonNegative(String text) {
		int number = parseStringToInt(text);
		throwIfValueIsNegative(number);
		this.value = number;
	}

	public NonNegative(int value) {
		throwIfValueIsNegative(value);
		this.value = value;
	}

	private int parseStringToInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자 변환 예외", e.getCause());
		}
	}

	private void throwIfValueIsNegative(int number) {
		if (number < 0) {
			throw new RuntimeException("음수입니다.");
		}
	}

	public int toResult() {
		return this.value;
	}

	public NonNegative add(NonNegative operand) {
		int result = this.value + operand.value;
		return new NonNegative(result);
	}

}
