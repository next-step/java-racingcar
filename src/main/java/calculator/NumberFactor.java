package calculator;

public class NumberFactor implements InputFactor<Integer> {
	private final int value;

	public NumberFactor(String value) {
		this.value = Integer.parseInt(value);
	}

	public NumberFactor(int value) {
		this.value = value;
	}

	@Override
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
		if (obj == this) return true;
		if (!(obj instanceof NumberFactor)) {
			return false;
		}

		return this.valueOfFactor().equals(((NumberFactor) obj).valueOfFactor());
	}
}
