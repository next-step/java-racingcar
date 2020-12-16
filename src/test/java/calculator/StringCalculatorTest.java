package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
	@Test
	@DisplayName("입력 값이 null이면 IllegalArgumentException이 발생한다.")
	void validateInput_ThrowIllegalArgumentExceptionWhenNull() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.validateInput(null))
			.withMessage(Message.INPUT_STRING);
	}

	@Test
	@DisplayName("입력 값이 빈 공백이면 IllegalArgumentException이 발생한다.")
	void validateInput_ThrowIllegalArgumentExceptionWhenEmpty() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.validateInput(""))
			.withMessage(Message.INPUT_STRING);
	}

	@Test
	@DisplayName("입력 값이 연산에 필요한 최소 문자열 갯수보다 작으면 IllegalArgumentException이 발생한다.")
	void splitBySpace_ThrowIllegalArgumentExceptionWhenLessThanMinSize() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.splitBySpace("1 *"))
			.withMessage(Message.INPUT_WRONG_STRING);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.splitBySpace("1 2"))
			.withMessage(Message.INPUT_WRONG_STRING);
	}

	@Test
	@DisplayName("입력 값이 최소 문자열 갯수보단 많지만 수식을 만들수 없는 문자열일 경우 IllegalArgumentException이 발생한다.")
	void splitBySpace_ThrowIllegalArgumentExceptionWhenNotSizeToMakeFormula() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.splitBySpace("1 * 4 /"))
			.withMessage(Message.INPUT_WRONG_STRING);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.splitBySpace("1 * 4 / 2 3"))
			.withMessage(Message.INPUT_WRONG_STRING);
	}

	@Test
	@DisplayName("입력 값이 최소 문자열 갯수보다 많고 홀수 갯수이면 공백으로 문자열을 분리한다.")
	void splitBySpace() {
		assertThat(StringCalculator.splitBySpace("1 * 2"))
			.containsExactly("1", "*", "2");

		assertThat(StringCalculator.splitBySpace("1 * 2 / 2"))
			.containsExactly("1", "*", "2", "/", "2");

		assertThat(StringCalculator.splitBySpace("1 * 2 3 4"))
			.containsExactly("1", "*", "2", "3", "4");
	}

	@Test
	@DisplayName("입력 값을 index에 따라 operand와 operator로 분류한다.")
	void groupingByClassTypeTest() {
		String[] inputStrings = {"1", "*", "2", "/", "2"};
		Map<OperationElement, List<String>> classTypeGroups = StringCalculator.groupingByClassType(inputStrings);

		assertThat(classTypeGroups.size()).isEqualTo(2);
		assertThat(classTypeGroups.get(OperationElement.OPERAND))
			.containsExactly("1", "2", "2");
		assertThat(classTypeGroups.get(OperationElement.OPERATOR))
			.containsExactly("*", "/");
	}

	@Test
	@DisplayName("연산자 자리에 이상한 값이 들어갈 경우 IllegalArgumentException이 발생한다.")
	void create_ThrowIllegalArgumentExceptionWhenWrongOperator() {

		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.create("1 * 2 3 4"))
			.withMessage(Message.UNDEFINED_OPERATOR);
	}

	@Test
	@DisplayName("연산자 자리에 이상한 값이 들어갈 경우 IllegalArgumentException이 발생한다.")
	void create_ThrowIllegalArgumentExceptionWhenWrongOperand() {

		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringCalculator.create("1 * 2 / +"))
			.withMessage(Message.INVALID_STRING_FOR_OPERAND);
	}

	@Test
	@DisplayName("정상적으로 StringCalculator를 생성한다.")
	void createTest() {
		StringCalculator stringCalculator = StringCalculator.create("1 * 2 / 2");

		assertThat(stringCalculator).isInstanceOf(StringCalculator.class)
			.isNotNull();
	}

	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2,10", "13 * 5 - 2 / 3,21"})
	void calculateTest(String input, int excepted) {
		assertThat(StringCalculator.create(input).calculate())
			.isEqualTo(excepted);
	}
}
