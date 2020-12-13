package edu.nextstep.racing.domain.game.cars.car;

import java.util.Objects;

public class Name {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public Name(String name) {
		if (name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("올바른 이름 형식이 아닙니다.");
		}
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "글자 이하여야 합니다.");
		}
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Name)) {
			return false;
		}
		Name name1 = (Name)o;
		return name.equals(name1.name);
	}

	public String getValue() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
