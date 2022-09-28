package racingcar.step3;

public class GameAttribute {

	public static final int MINIMUM_VALID_NUMBER = 0;
	private final int carCount;
	private final int tryCount;

	public GameAttribute(int carCount, int tryCount) {
		validateNegative(carCount);
		validateNegative(tryCount);
		this.carCount = carCount;
		this.tryCount = tryCount;
	}

	public int getCarCount() {
		return carCount;
	}

	public int getTryCount() {
		return tryCount;
	}

	private void validateNegative(int value) {
		if (value <= MINIMUM_VALID_NUMBER) {
			throw new NumberFormatException("0이하의 수는 유효하지 않습니다.");
		}
	}
}
