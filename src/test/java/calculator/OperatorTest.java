package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

	StringCaculator stringCaculator = new StringCaculator();

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", "  ", "1 A 3"})
	@DisplayName("입력값이 잘못됐을 경우 예외처리 테스트")
	void throwException_WhenInvalidInput(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			stringCaculator.validate(input);
		});
	}

}
