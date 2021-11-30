package study.racingcar.domain;

import java.util.Objects;

public class Name {

	private static final String INPUT_NAME = "이름을 입력해주세요.";
	private static final String INPUT_NAME_LENGTH_LIMIT = "이름의 길이는 5자 미만이여야 합니다.";
	private static final int MAX_LENGTH = 5;

	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	public String value() {
		return name;
	}

	private void validateName(String name) {
		checkNameBlank(name);
		checkNameLength(name);
	}

	private void checkNameBlank(String name) {
		if(" ".equals(name)){
			throw new IllegalArgumentException(INPUT_NAME);
		}
	}

	private void checkNameLength(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(INPUT_NAME_LENGTH_LIMIT);
		}
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

}
