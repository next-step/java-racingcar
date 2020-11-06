package nextstep.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 기능 요구사항
 * 1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * 3. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * 4. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 5. 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class StringCalculatorTest {
	private StringCalculator underTest = new StringCalculator();

	@ParameterizedTest
	@DisplayName("덧셈 테스트")
	@CsvSource({"0 + 1,1", "1 + 1,2", "10 + 20,30", "111 + 11,122", "1 + 2 + 3 + 4,10"})
	public void plusTest(String input, int expected) {
		assertThat(underTest.calculate(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("뺄셈 테스트")
	@CsvSource({"3 - 1,2", "5 - 2,3", "111 - 11,100", "5 - 1 - 1,3", "10 - 2 - 3 - 1,4"})
	public void minusTest(String input, int expected) {
		assertThat(underTest.calculate(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("곱셈 테스트")
	@CsvSource({"3 * 1,3", "5 * 2,10", "111 * 11,1221", "5 * 1 * 1,5", "10 * 2 * 3 * 1,60"})
	public void multiplicationTest(String input, int expected) {
		assertThat(underTest.calculate(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("나눗셈 테스트")
	@CsvSource({"3 / 1,3", "5 / 5,1", "110 / 10,11", "200 / 2 / 5,20", "30 / 2 / 5 / 1,3"})
	public void divisionTest(String input, int expected) {
		assertThat(underTest.calculate(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("사칙 연산을 모두 섞어서 테스트")
	@CsvSource({"10 + 20 - 2 / 2 * 1,14", "2 + 2 - 2 * 2 / 2,2"})
	public void calculateTest(String input, int expected) {
		assertThat(underTest.calculate(input)).isEqualTo(expected);
	}

	@Test
	@DisplayName("나눗셈은 0으로 떨어져야 한다.")
	public void divisionExceptionTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.calculate("10 / 3"))
				.withMessage("divide into integers.");
	}

	@Test
	@DisplayName("수식이 널이라면 에러를 던진다.")
	public void validateFomulaIsNullTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validateCheck(null))
				.withMessage("the input value is empty!!");
	}

	@Test
	@DisplayName("수식이 비었다면 에러를 던진다.")
	public void validateFomulaisBlankTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validateCheck(""))
				.withMessage("the input value is empty!!");
	}

	@Test
	@DisplayName("들어온 수식의 홀수자리가 숫자가 아니라면 에러를 던진다.")
	public void validateNumberTestThrowException() {
		List<String> numbers = Arrays.asList("1", "10", "/");
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validateNumber(numbers))
				.withMessage("wrong number!!");
	}

	@Test
	@DisplayName("들어온 수식의 짝수자리가 사칙연산이 아니라면 에러를 던진다.")
	public void validateOperatorTest() {
		List<String> operators = Arrays.asList("+", "*", "5");
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validateOperator(operators))
				.withMessage("wrong operator!!");
	}

	@Test
	@DisplayName("들어온 수식에 사칙연산이 아닌 기호가 들어오면 에러를 던진다.")
	public void validateOperatorTest2() {
		List<String> operators = Arrays.asList("+", "*", "-", "/", "%");
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validateOperator(operators))
				.withMessage("wrong operator!!");
	}

	@Test
	@DisplayName("들어온 수식은 공백기준 숫자와 사칙연산으로 나눌수 있어야 한다.")
	public void validateFormulaWithSpace() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			underTest.calculate("1 + 2*2");
		}).withMessage("wrong number!!");
	}
}
