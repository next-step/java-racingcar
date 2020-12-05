package step2.calculator;

public class Number {
	private final Integer value;

	public Number(final Integer value) {
		this.value = value;
	}

	public static boolean isIntegerNumber(final String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Integer getValue() {
		return value;
	}


}
