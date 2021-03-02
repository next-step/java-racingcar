package im.juniq.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	@DisplayName("덧셈 테스트")
	@ParameterizedTest
	@CsvSource({"2 + 3, 5", "2 + 3 + 1, 6", "2 + 3 + 1 + 7, 13"})
	void add(String input, int expected) {
		assertThat(new Calculator(input).calculate()).isEqualTo(expected);
	}
}
