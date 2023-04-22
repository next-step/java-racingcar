package step5_racingcar_refactoring.domain;

public class CarName {
	private static final String NULL_EMPTY = "널이거나 빈값입니다";
	private static final String NAMINGRULE = "자동차 이름을 길게 작성했습니다";
	private static final int RULE_NAME_LENGTH_MAX = 5;

	private final String carName;

	public CarName(String carName)
	{
		this.carName = isNameLengthAcceptable(carName);
	}

	public String isNameLengthAcceptable(String name) {
		if (name == null || name.isBlank()) {
			throw new RuntimeException(NULL_EMPTY);
		}

		if (RULE_NAME_LENGTH_MAX < name.length()) {
			throw new RuntimeException(NAMINGRULE);
		}

		return name;
	}

	public String getCarName() {
		return carName;
	}
}
