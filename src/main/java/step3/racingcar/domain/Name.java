package step3.racingcar.domain;

public class Name {

	private final String name;

	public Name(final String name) {
		this.validate(name);
		this.name = name;
	}

	private void validate(final String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 필수 값입니다");
		}

		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
	}

	public String getName() {
		return name;
	}
}
