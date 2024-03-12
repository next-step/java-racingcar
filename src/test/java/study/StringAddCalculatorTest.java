package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
	StringAddCalculator calculator = new StringAddCalculator();
	@Test
	@DisplayName("빈 문자열 입력할 경우 0을 반환한다.")
	public void calculateEmptyStringThenReturn0() {
		assertThat(calculator.calculate("")).isEqualTo(0);
	}

	@Test
	@DisplayName("null 값을 입력할 경우 0을 반환한다.")
	public void calculateNullThenReturn0() {
		assertThat(calculator.calculate(null)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
	public void calculateOneNumberThenReturnOneNumber() {
		assertThat(calculator.calculate("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("컴마와 콜론으로 문자열을 나눌 수 있다.")
	public void splitByCommaAndColon() {
		assertThat(calculator.splitByCustomDelimiter("1,2:3")).isEqualTo(new String[]{"1", "2", "3"});
	}

	@Test
	@DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정하여 문자열을 나눌 수 있다.")
	public void splitByCustomDelimiter() {
		assertThat(calculator.splitByCustomDelimiter("//;\n1:2;3,")).isEqualTo(new String[]{"1", "2", "3"});
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
