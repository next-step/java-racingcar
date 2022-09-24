package calculator;

import calculator.exception.NegativeException;
import calculator.exception.NotANumberException;

@Deprecated
public class Positive {

	private final Integer integer;

	public Positive(int integer) {
		if (integer < 0) {
			throw new NegativeException();
		}
		this.integer = integer;
	}

	public static Positive ofString(String number) {
		try {
			return new Positive(Integer.parseInt(number));
		} catch (NumberFormatException exception) {
			throw new NotANumberException();
		}
	}

	public Positive plus(Positive other) {
		return new Positive(integer + other.integer);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Positive positive = (Positive)o;

		return integer.equals(positive.integer);
	}

	@Override
	public int hashCode() {
		return integer.hashCode();
	}

	@Override
	public String toString() {
		return "Positive{" +
			"integer=" + integer +
			'}';
	}
}
