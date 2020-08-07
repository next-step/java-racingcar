package simpleracing.execute;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
	ADVANCE("-"),
	STOP(StringUtils.EMPTY);

	private static final int ADVANCE_CONDITION_VALUE = 4;

	private final String sign;

	public static Direction getBy(int value) {
		return value >= ADVANCE_CONDITION_VALUE ? Direction.ADVANCE : Direction.STOP;
	}
}
