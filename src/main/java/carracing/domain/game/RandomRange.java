package carracing.domain.game;

import carracing.util.controlstatement.Boolean;
import carracing.util.controlstatement.GreaterThan;
import carracing.util.controlstatement.GreaterThanOrEqualTo;
import carracing.util.controlstatement.IF;
import carracing.util.controlstatement.LessThan;
import carracing.util.controlstatement.OR;

public class RandomRange implements MovingStrategy {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 9;
	private static final int MOVING_STANDARD = 4;
	private final int min;
	private final int max;

	public RandomRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int intValue() {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	@Override
	public boolean isPossible() {
		final int randomValue = this.intValue();
		checkRandomValueIsValid(randomValue);
		Boolean greaterThanOrEqualTo =
				new IF(
						new GreaterThanOrEqualTo(randomValue, MOVING_STANDARD)
				);

		return greaterThanOrEqualTo.booleanValue();
	}

	private void checkRandomValueIsValid(int randomValue) {
		if (isInValidRange(randomValue)) {
			throw new IllegalArgumentException(
					String.format("%d 이상, %d 이하만 가능합니다", MIN_VALUE, MAX_VALUE)
			);
		}
	}

	private boolean isInValidRange(int randomValue) {
		Boolean lessThanOrGreaterThan =
				new IF(
						new OR(
								new LessThan(randomValue, MIN_VALUE),
								new GreaterThan(randomValue, MAX_VALUE)
						)
				);

		return lessThanOrGreaterThan.booleanValue();
	}
}
