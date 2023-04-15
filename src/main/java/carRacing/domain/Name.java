package carRacing.domain;

import carRacing.exception.CarNameException;

public class Name {
	private final String name;

	public Name(String name) {
		if (name.isBlank()) {
			throw new CarNameException("자동차의 이름은 빈값일 수 없습니다.");
		}
		if (name.length() > 5) {
			throw new CarNameException("자동차의 이름은 5자를 초과할 수 없습니다.");
		}

		this.name = name;
	}
}
