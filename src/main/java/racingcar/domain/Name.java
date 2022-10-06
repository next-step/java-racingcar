package racingcar.domain;

import java.util.Objects;

public class Name extends Condition {

	private final String name;

	public Name(String input) {
		super(new NameCondition());
		if (validInput(input)) {
			throw new IllegalArgumentException("자동차 이름은 공백 또는 5 자를 초과할 수 없습니다");
		}
		this.name = input;
	}

	public String getName() {
		return name;
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
