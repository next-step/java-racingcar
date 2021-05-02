package racingcar;

public class RoundCount {
	private static final int MINIMUM_VALUE = 1;
	private int roundCount;

	public RoundCount(int roundCount) {
		if (roundCount < MINIMUM_VALUE) {
			throw new IllegalArgumentException("경주 횟수는 1회 이상이어야 합니다.");
		}
		this.roundCount = roundCount;
	}

	public int get() {
		return roundCount;
	}
}
