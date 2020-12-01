package calculator;

import java.math.BigDecimal;
import java.util.Objects;

public class Number {
	private final BigDecimal value;

	public Number(String value) {
		this.value = new BigDecimal(value);
	}

	public Number(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal valueOf() {
		return this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Number number = (Number) o;
		return Objects.equals(value, number.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
