package racingcar.wrapper;

public class Name {
	private static final int DEFAULT_MAX_LENGTH = 5;
	private String name;

	public Name(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("이름은 한 글자 이상 입력해야합니다.");
		}
		if (name.length() > DEFAULT_MAX_LENGTH) {
			throw new IllegalArgumentException("이름은 " + DEFAULT_MAX_LENGTH + "글자 이하만 입력 가능합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
