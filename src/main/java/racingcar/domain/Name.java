package racingcar.domain;

import racingcar.exception.NameException;

public class Name {

	private static final int NAME_LENGTH_MAXIMUM = 5;

	private final String name;

	public Name(final String name) {
		validateNameLength(name);
		validateNameNotBlank(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		if (name.isEmpty()) {
			throw new NameException("이름은 1글자 이상입니다");
		}
		if (name.length() > NAME_LENGTH_MAXIMUM) {
			throw new NameException("이름은 5글자 이하입니다");
		}
	}

	private void validateNameNotBlank(String name) {
		if (name.isBlank()) {
			throw new NameException("이름은 공백이 될 수 없습니다");
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name{" +
			"name='" + name + '\'' +
			'}';
	}
}
