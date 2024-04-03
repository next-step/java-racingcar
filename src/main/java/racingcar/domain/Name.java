package racingcar.domain;

import java.util.Objects;

public class Name {
	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private static final String DEFAULT_NAME = "noop";

	private final String value;

	public Name(String name) {
		if (name.length() > CAR_NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("car name should under 5");
		}
		this.value = name;
	}

	public static Name createDefaultInstance() {
		return new Name(DEFAULT_NAME);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name)o;
		return Objects.equals(value, name.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}
