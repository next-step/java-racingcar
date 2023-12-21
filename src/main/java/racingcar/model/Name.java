package racingcar.model;

import java.util.Objects;

public class Name {
	private static final int NAME_LIMIT = 5;
	private static final int EMPTY_NAME = 0;
	private final String name;

	public Name(final String name) {
		this.name = validateLength(name);
	}

	public String name() {
		return this.name;
	}

	private String validateLength(final String name) {
		if (name.length() > NAME_LIMIT || name.length() <= EMPTY_NAME) {
			throw new IllegalArgumentException("이름은 5자를 넘어갈 수 없습니다.");
		}
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
