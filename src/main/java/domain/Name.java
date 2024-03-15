package domain;

public class Name {
	private String name;

	public Name(String name) {
		this.name = name;
		validateCarName();
	}

	public void validateCarName() {
		if (name.length() > 5) {
			throw new IllegalArgumentException("글자수가 5를 초과했습니다. 다시 입력해주세요.");
		}
	}

	public String getName() {
		return name;
	}
}
