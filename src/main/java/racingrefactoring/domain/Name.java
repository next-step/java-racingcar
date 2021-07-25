package racingrefactoring.domain;

import java.util.Objects;

public class Name {

	private final String name;

	public Name(String name) {
		if (CarValidator.isInvalidName(name)) {
			throw new CarNameException();
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Name name1 = (Name) o;

		return Objects.equals(name, name1.name);
	}

}
