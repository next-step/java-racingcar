package simpleracing.execute;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
	ADVANCE("-"),
	STOP(StringUtils.EMPTY);

	static final int ADVANCE_CONDITION_VALUE = 4;

	final String sign;

	public static Direction getBy(int value) {
		return value >= ADVANCE_CONDITION_VALUE ? Direction.ADVANCE : Direction.STOP;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
