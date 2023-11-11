package carRacing.domain;

public class Name {

	private String name;

	private static final int LIMIT_NAME_LENGTH = 5;

	public Name(String name) {
		this.name = validLengthName(name);
	}

	public String validLengthName(String carName) {
		if (carName.length() >= LIMIT_NAME_LENGTH) {
			throw new IllegalArgumentException("이름이 5자를 초과했습니다.");
		}
		return carName;
	}

	@Override
	public String toString() {
		return name;
	}
}
