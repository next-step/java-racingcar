package racingcar;

public class CarName {
	public static final String NAME_CORRECT_CONDITION = "이름이 5자를 초과함.";
	private final String name;

	public CarName(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException(NAME_CORRECT_CONDITION);
		}
		this.name = name;
	}
}
