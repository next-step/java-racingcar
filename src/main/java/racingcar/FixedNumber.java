package racingcar;

public class FixedNumber implements NumberStrategy {

	private final int desiredNumber;

	public FixedNumber(int desiredNumber) {
		this.desiredNumber = desiredNumber;
	}

	public int generate() {
		return desiredNumber;
	}
}
