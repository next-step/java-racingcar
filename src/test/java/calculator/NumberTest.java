package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

	private Number baseNumber;
	private Number calculationNumber;
	private NumberHelper numberHelper;

	@BeforeEach
	void setUp() {
		baseNumber = new Number("1");
		calculationNumber = new Number("3");
		numberHelper = new NumberHelper();
	}

	@DisplayName("숫자 객체간 더하기를 할수있어야한다.")
	@Test
	void shouldAbleToEachNumberObjectAdded() {
		assertThat(numberHelper.add(baseNumber, calculationNumber)).isEqualTo(new Number("4"));
	}

	@DisplayName("숫자 객체간 값이 같은지 비교가 가능해야한다.")
	@Test
	void shouldCheckEqualsEachNumberObject() {
		assertThat(numberHelper.add(baseNumber, calculationNumber).equals(new Number("4"))).isTrue();
	}

	@DisplayName("숫자 객체간 뺄셈을 할수있어야한다.")
	@Test
	void shouldAbleToEachNumberObjectSubtract() {
		assertThat(numberHelper.subtract(baseNumber, calculationNumber)).isEqualTo(new Number("-2"));
	}

	@DisplayName("숫자 객체간 곱셈을 할수있어야한다.")
	@Test
	void shouldAbleToEachNumberObjectMultiply() {
		assertThat(numberHelper.multiply(baseNumber, calculationNumber)).isEqualTo(new Number("3"));
	}

	@DisplayName("숫자 객체간 나눗셈을 할수있어야한다.")
	@Test
	void shouldAbleToEachNumberObjectDivide() {
		baseNumber = new Number("10");
		calculationNumber = new Number("5");
		assertThat(numberHelper.divide(baseNumber, calculationNumber)).isEqualTo(new Number("2"));
	}
}
