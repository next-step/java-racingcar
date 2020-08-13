package step5.domain;

public class CarName {
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final String SEPARATOR = ",";
	private final String name;

	public CarName(String name) {
		this.name = isNameLengthOverLimit(name);
	}

	public String getValue() {
		return name;
	}

	private String isNameLengthOverLimit(String name) {
		if (name.length() <= NAME_LENGTH_LIMIT) {
			return name;
		}
		throw new IllegalArgumentException("이름은 최대 5자까지 입력 가능합니다.");
	}

}
