package step2;

public class Operand {
	private final int value;

	private Operand(int value) {
		this.value = value;
	}

	public static Operand create(String stringValue) {
		try {
			return new Operand(Integer.parseInt(stringValue));
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INVALID_STRING_FOR_OPERAND);
		}
	}

	public int getValue() {
		return value;
	}
}
