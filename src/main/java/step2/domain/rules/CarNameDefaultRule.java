package step2.domain.rules;

public class CarNameDefaultRule extends CarNameRule {

	private static final int MIN_CAR_NUMBERS = 1;

	public CarNameDefaultRule(String carNamesBeforeParsed, String delimiter) {
		super(carNamesBeforeParsed, delimiter);
	}

	@Override
	public String[] parse(String carNamesBeforeParsed, String delimiter) {
		return validateCarNumbers(carNamesBeforeParsed.split(delimiter));
	}

	private String[] validateCarNumbers(String[] carNames) {
		if (carNames.length < MIN_CAR_NUMBERS) {
			throw new IllegalArgumentException(String.format("자동차 수는 1대 미만일 수 없습니다. " +
					"입력한 자동차 수(%s}를 확인해주세요!)", carNames.length));
		}
		return carNames;
	}

}
