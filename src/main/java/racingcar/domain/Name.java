package racingcar.domain;

import racingcar.exception.NameException;

public class Name {

	private static final String DEFAULT_NAME = "이름 없음";

	private final String name;

	public Name() {
		this(DEFAULT_NAME);
	}

	public Name(String name) {
		validateNameLength(name);
		validateNameNotBlank(name);
		this.name = name;
	}

	public void validateNameLength(String name) {
		if (name.length() < 1) {
			throw new NameException("이름은 1글자 이상입니다");
		}
		if (name.length() > 5) {
			throw new NameException("이름은 5글자 이하입니다");
		}
	}

	public void validateNameNotBlank(String name) {
		if (name.isBlank()) {
			throw new NameException("이름은 공백이 될 수 없습니다");
		}
	}

	public String getName() {
		return name;
	}
}
