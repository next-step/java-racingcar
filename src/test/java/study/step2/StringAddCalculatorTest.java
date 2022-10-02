package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import study.step2.StringAddCalculator;

public class StringAddCalculatorTest {


	final StringAddCalculator stringAddCalculator = new StringAddCalculator();

	@ParameterizedTest(name = "빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
	@NullAndEmptySource
	public void Given_NullOrEmpty_Then_ReturnZero(String input) {
		int result = stringAddCalculator.splitAndSum(input);

		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	@Test
	public void Given_Number_Then_ReturnNumber() throws Exception {
		int result = stringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
	@Test
	public void Given_Numbers_Then_ReturnSum() throws Exception {
		int result = stringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("구분자는 컴마(,), 콜론(:)을 사용한다.")
	@Test
	public void Given_DefaultDelimiter_Then_ReturnSum() throws Exception {
		int result = stringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정한다.")
	@Test
	public void Given_CustomDelimiter_Then_ReturnSum() throws Exception {
		int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("커스텀 구분자가 아닌 경우 에러를 던진다.")
	@Test
	public void Given_NotCustomDelimiter_Then_ThrowException() throws Exception {
		assertThatThrownBy(() -> stringAddCalculator.splitAndSum("//-\n1;2;3"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("음수를 전달할 경우 RuntimeException 예외를 던진다.")
	@Test
	public void Given_Negative_Then_ThrowException() throws Exception {
		assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자 이외의 값을 전달할 경우 RuntimeException 예외를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c", "1,2,c", "1,b,&"})
	public void splitAndSum_string(String string) throws Exception {
		assertThatThrownBy(() -> stringAddCalculator.splitAndSum(string))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
