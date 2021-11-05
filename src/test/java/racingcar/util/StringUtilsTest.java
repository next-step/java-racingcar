package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringUtilsTest {
	@DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 true")
	@ParameterizedTest
	@NullAndEmptySource
	void isEmpty(String input) {
		// when
		boolean result = StringUtils.isEmpty(input);
		assertThat(result).isTrue();
	}
}