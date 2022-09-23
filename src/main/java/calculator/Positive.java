package calculator;

public class Positive {

	private final Integer integer;

	public Positive(int integer) {
		if (integer < 0)
			throw new RuntimeException("음수가 있습니다");
		this.integer = integer;
	}

	public Positive(String number) {
		this(Integer.parseInt(number));
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
