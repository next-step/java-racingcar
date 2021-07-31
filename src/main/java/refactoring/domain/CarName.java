package refactoring.domain;

public class CarName {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public CarName(String name) {
		validateName(name);

		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validateName(String name) {
		if (isEmpty(name)) {
			throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
		}

		if (checkLength(name)) {
			throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이상 초과할 수 없습니다.");
		}
	}

	private boolean checkLength(String name) {
		return name.length() > MAX_NAME_LENGTH;
	}

	private boolean isEmpty(String name) {
		if (name == null || "".equals(name)) {
			return true;
		}

		return name.isEmpty();
	}
}
