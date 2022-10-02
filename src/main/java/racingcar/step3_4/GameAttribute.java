package racingcar.step3_4;

import java.util.List;

public class GameAttribute {

	private static final int MINIMUM_CAR_NAMES_COUNT = 1;
	private static final int MINIMUM_VALID_NUMBER = 0;

	private final List<String> carNames;
	private final int tryCount;

	public GameAttribute(List<String> carNames, int tryCount) {
		validateEmpty(carNames);
		validateNegative(tryCount);
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	private void validateEmpty(List<String> carNames) {
		if (carNames.size() < MINIMUM_CAR_NAMES_COUNT) {
			throw new IllegalArgumentException("자동차 이름을 1개 이상 입력해주세요.");
		}
	}

	private void validateNegative(int value) {
		if (value <= MINIMUM_VALID_NUMBER) {
			throw new NumberFormatException("0이하의 수는 유효하지 않습니다.");
		}
	}

	public List<String> getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}

}
