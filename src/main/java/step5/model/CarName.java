package step5.model;

import java.util.Objects;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public CarName(final String name) {
		checkNameCondition(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void checkNameCondition(final String name) {
		if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
			throw new IllegalArgumentException("이름의 길이는 적어도 1자 이상 5자 이하이어야 합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CarName carName1 = (CarName) o;
		return Objects.equals(name, carName1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
