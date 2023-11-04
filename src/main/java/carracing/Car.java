package carracing;

import carracing.controlstatement.Boolean;
import carracing.controlstatement.MoreThan;

public class Car {
	private static final int MOVING_STANDARD = 4;
	private static final int MOVING_DISTANCE = 1;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 10;
	private int movingDistance;

	public Car() {
		this(0);
	}

	public Car(int movingDistance) {
		this.movingDistance = movingDistance;
	}

	public void move(RandomRange randomRange) {
		final int randomValue = randomRange.intValue();
		checkRandomValueIsValid(randomValue);
		Boolean boolMoreThan = new MoreThan(randomValue, MOVING_STANDARD);

		if (boolMoreThan.value()) {
			moveDistance();
		}
	}

	public void checkRandomValueIsValid(int randomValue) {
		if (isInValidRange(randomValue)) {
			throw new IllegalArgumentException(
					String.format("%d 이상, %d 이하만 가능합니다", MIN_VALUE, MAX_VALUE)
			);
		}
	}

	private boolean isInValidRange(int randomValue) {
		return randomValue < MIN_VALUE || randomValue > MAX_VALUE;
	}

	private void moveDistance() {
		this.movingDistance += MOVING_DISTANCE;
	}

	public int movingDistance() {
		return this.movingDistance;
	}
}
