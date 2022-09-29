package racingcar.step3_4;

public class GameAttribute {

	private static final int MINIMUM_CAR_NAMES_COUNT = 1;
	private static final int MINIMUM_VALID_NUMBER = 0;

	private final Names carNames;
	private final int tryCount;

	public GameAttribute(Names carNames, int tryCount) {
		validateEmpty(carNames);
		validateNegative(tryCount);
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	private void validateEmpty(Names carNames) {
		if (carNames.getCount() < MINIMUM_CAR_NAMES_COUNT) {
			throw new IllegalArgumentException("자동차 이름을 1개 이상 입력해주세요.");
		}
	}

	private void validateNegative(int value) {
		if (value <= MINIMUM_VALID_NUMBER) {
			throw new NumberFormatException("0이하의 수는 유효하지 않습니다.");
		}
	}

	public Names getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}

}
