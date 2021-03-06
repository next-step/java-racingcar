package camp.nextstep.edu.racingcar.entity;

import static camp.nextstep.edu.util.StringUtil.*;

import java.util.Objects;

public class Name {
	private final static int MAX_NAME_SIZE = 5;
	private final String name;

	public Name(String name) {
		if (isBlank(name)) {
			throw new IllegalArgumentException("자동차 이름은 빈값은 불가합니다.");
		}

		if (name.length() > MAX_NAME_SIZE) {
			throw new IllegalArgumentException("자동차 이름은 5자 이내입니다.");
		}

		this.name = name;
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

	@Override
	public String toString() {
		return this.name;
	}
}
