package racingrefactoring.domain;

public class ForwardCount {

	private int value;

	public ForwardCount() {
		this(0);
	}

	public ForwardCount(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public void increase() {
		value++;
	}

	public boolean isPositive() {
		return greaterThan(0);
	}

	public boolean greaterThan(int value) {
		return this.value > value;
	}

	public boolean isSame(int winnerCount) {
		return value == winnerCount;
	}

	public int value() {
		return value;
	}

}
