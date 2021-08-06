package step4;

import java.util.Objects;

public class Name {

	private static final int CAR_NAME_RANGE = 5;

	private String name;

	public Name(final String name) {
		if (name.length() > CAR_NAME_RANGE) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name1 = (Name) o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
