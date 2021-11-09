package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

public class CalculatorTest {

	@Test
	@DisplayName("더하기 연산을 한다")
	void add() {
		InputNumber input = new InputNumber("1 + 3");
		assertThat(Calculator.calculate(input)).isEqualTo(4);
	}

	@Test
	@DisplayName("빼기 연산을 한다")
	void minus() {
		InputNumber input = new InputNumber("3 - 1");
		assertThat(Calculator.calculate(input)).isEqualTo(2);
	}

	@Test
	@DisplayName("곱셈 연산을 한다")
	void times() {
		InputNumber input = new InputNumber("2 * 4");
		assertThat(Calculator.calculate(input)).isEqualTo(8);
	}

	@Test
	@DisplayName("나눗셈 연산을 한다")
	void divide() {
		InputNumber input = new InputNumber("4 / 2");
		assertThat(Calculator.calculate(input)).isEqualTo(2);
	}

	@ParameterizedTest
	@DisplayName("사칙 연산 모두를 포함하는 기능을 테스트 한다")
	@CsvSource(value = {"1 + 2 * 3 / 3 - 1:2"}, delimiter = ':')
	void allCalc(String input, double result) {
		InputNumber inputNumber = new InputNumber(input);
		assertThat(Calculator.calculate(inputNumber)).isEqualTo(result);
	}

}
