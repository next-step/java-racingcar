package calculator;

public class NumberFactor {
	private final int value;

	public NumberFactor(String value) {
		this.value = Integer.parseInt(value);
	}

	public NumberFactor(int value) {
		this.value = value;
	}

	public static NumberFactor createFactor(int value) {
		return new NumberFactor(value);
	}

	public static boolean validator(String value) {
		try {
			Double.parseDouble(value);
		} catch (Exception isNotNumericException) {
			return false;
		}
		return true;
	}

	public Integer valueOfFactor() {
		return this.value;
	}


	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + valueOfFactor().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof NumberFactor)) {
			return false;
		}

		return this.valueOfFactor().equals(((NumberFactor) obj).valueOfFactor());
	}
}
