package racingcar.domain;

import java.util.Objects;

import racingcar.utils.Message;
import racingcar.utils.ValidationUtils;

public class Name {
	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		ValidationUtils.validateEmpty(name);
		validateFiveCharacters(name);
	}

	private void validateFiveCharacters(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException(Message.INVALID_CAR_NAME_LENGTH);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Name))
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
