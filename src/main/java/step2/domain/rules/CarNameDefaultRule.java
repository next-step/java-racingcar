package step2.domain.rules;

public class CarNameDefaultRule extends CarNameRule {

	private static final int MIN_CAR_NUMBERS = 1;

	public CarNameDefaultRule(String carNamesBeforeParsed) {
		super(carNamesBeforeParsed);
	}

	@Override
	public String[] parse(String carNamesBeforeParsed) {
		return validateCarNumbers(carNamesBeforeParsed.split(","));
	}

	private String[] validateCarNumbers(String[] carNames) {
		if (carNames.length < MIN_CAR_NUMBERS) {
			throw new IllegalArgumentException(String.format("자동차 수는 1대 미만일 수 없습니다. " +
					"입력한 자동차 수(%s}를 확인해주세요!)", carNames.length));
		}
		return carNames;
	}

}
