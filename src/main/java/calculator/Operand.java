package calculator;

public class Operand {
	private final int value;

	public Operand(int value) {
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

	@Override
	public boolean equals(Object object) {
		if (object instanceof Operand) {
			return this.value == ((Operand)object).value;
		}

		return false;
	}
}
