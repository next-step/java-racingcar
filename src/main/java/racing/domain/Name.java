package racing.domain;

import racing.utils.Validation;

public class Name {

	private static final int CHECK_LENGTH = 4;
	private static final String NAME_EMPTY_MESSAGE = "이름이 빈값이 될 수 없습니다.";
	private static final String NAME_LIMIT_LENGTH_MESSAGE = "이름은 " + CHECK_LENGTH + "자리까지 허용됩니다.";

	private final String name;

	public Name(String name) {
		Validation.validEmptyCheck(name, NAME_EMPTY_MESSAGE);
		Validation.validStringLength(name, CHECK_LENGTH, NAME_LIMIT_LENGTH_MESSAGE);
		this.name = name;
	}

	public String printName() {
		return this.name;
	}
}
