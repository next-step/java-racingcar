package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorViewTest {

	private CalculatorView calculatorView;

	@BeforeEach
	void setUp() {
		calculatorView = new CalculatorView();
	}

	@ParameterizedTest
	@CsvSource(value = {"6 + 2 / 4 * 2 - 3=1",
			"-3 * 2 * 4 / 2 + -3 - 5=-20",
			"3=3"}, delimiter = '=')
	@DisplayName("사칙연산 문자열을 통한 사칙연산 계산 테스트")
	void calculateByCalculator(String formulaExpression, Long expected) {
		// when
		Long result = calculatorView.calculateByCalculator(formulaExpression);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"6   2 / 4 * 2 - 3",
			"3 * 2 * 4 / 2 + 3 -"})
	@DisplayName("사칙연산 문자열을 통한 사칙연산 계산중 예외 확인")
	void calculateByCalculator_exception(String formulaExpression) {
		// when
		ThrowableAssert.ThrowingCallable callable = () -> calculatorView.calculateByCalculator(formulaExpression);

		// then
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(callable);
	}

	@Test
	@DisplayName("여러개의 피연산자, 연산자로부터 List<OperatingEntry> 를 만들어내는 함수 테스트")
	void createOperatingEntryList() {
		// given
		String[] strings = {"6","+","2","/","4"};

		// when
		List<OperatingEntry> operatingEntryList = calculatorView.createOperatingEntryList(strings);
		OperatingEntry entry1 = operatingEntryList.get(0);
		OperatingEntry entry2 = operatingEntryList.get(1);

		// then
		assertThat(operatingEntryList).hasSize(2);

		assertThat(entry1.getFourRuleOperator()).isEqualTo(FourRuleOperator.PLUS);
		assertThat(entry1.getOperand()).isEqualTo(2);

		assertThat(entry2.getFourRuleOperator()).isEqualTo(FourRuleOperator.DIVIDE);
		assertThat(entry2.getOperand()).isEqualTo(4);
	}

	@ParameterizedTest
	@CsvSource(value = {"+,2,PLUS,2", "-,0,MINUS,0", "*,-5,MULTIPLY,-5", "/,2,DIVIDE,2"})
	@DisplayName("피연산자, 연산자로부터 OperatingEntry 객체를 만들어내는 함수 테스트")
	void createOperatingEntry(String operatorIdentifier, String stringOperand,
	                          FourRuleOperator fourRuleOperator, Long operand) {
		// when
		OperatingEntry operatingEntry = calculatorView.createOperatingEntry(operatorIdentifier, stringOperand);

		// then
		assertThat(operatingEntry.getFourRuleOperator()).isEqualTo(fourRuleOperator);
		assertThat(operatingEntry.getOperand()).isEqualTo(operand);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1", "-5,-5", "0,0"})
	@DisplayName("문자Long 을 Long 으로 변환하는지 테스트")
	void toLongOperand_success(String stringOperand, Long expected) {
		// when
		long operand = calculatorView.toLongOperand(stringOperand);

		// then
		assertThat(operand).isEqualTo(expected);
	}

	@Test
	@DisplayName("잘못된 문자 Long 을 Long 으로 변환시에 기대했던 exception 이 뜨는지 테스트")
	void toLongOperand_exception() {
		// given
		String wrong1 = null;
		String wrong2 = " ";

		// when
		ThrowableAssert.ThrowingCallable callable1 = () -> calculatorView.toLongOperand(wrong1);
		ThrowableAssert.ThrowingCallable callable2 = () -> calculatorView.toLongOperand(wrong2);

		// then
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(callable1);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(callable2);
	}
}