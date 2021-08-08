package racingcar;

public class CarName {
	public static final String NAME_INCORRECT_MESSAGE = "이름이 5자를 초과함.";
	public static final int NAME_CORRECT_CONDITION = 5;
	private final String name;

	public CarName(String name) {
		if (name.length() > NAME_CORRECT_CONDITION) {
			throw new IllegalArgumentException(NAME_INCORRECT_MESSAGE);
		}
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
