package racingcar.car;

public class CarName {
	private final String name;

	public CarName(String name) {
		this.name = name;
		checkName();
	}

	private void checkName() {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("이름은 빈 값일 수 없습니다. 다시 입력해주세요");
		}

		if(name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.");
		}
	}

	public String getName() {
		return name;
	}
}
