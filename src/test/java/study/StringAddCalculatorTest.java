package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import util.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
	StringAddCalculator calculator = new StringAddCalculator();

	@DisplayName("빈 문자열이나 null을 입력할 경우 0을 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	public void calculateEmptyStringThenReturn0(String input) {
		assertThat(calculator.calculate(input)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
	public void calculateOneNumberThenReturnOneNumber() {
		assertThat(calculator.calculate("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("구분자로 나눈 숫자들의 합을 반환한다.")
	public void calculateString() {
		assertThat(calculator.calculate("//;\n1:2;3,")).isEqualTo(6);
	}

	@Test
	@DisplayName("음수를 전달할 경우 예외가 발생한다.")
	public void calculateMinusThenThrowException() {
		assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
				.isInstanceOf(RuntimeException.class);
	}
}
