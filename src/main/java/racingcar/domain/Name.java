package racingcar.domain;

import racingcar.exception.NameException;

public class Name {

	private static final int SINGLE = 1;
	private static final int FIVE = 5;

	private final String name;

	public Name(String name) {
		validateNameLength(name);
		validateNameNotBlank(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		if (name.length() < SINGLE) {
			throw new NameException("이름은 1글자 이상입니다");
		}
		if (name.length() > FIVE) {
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
}
