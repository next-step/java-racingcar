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
	void add() {
		InputNumber input = new InputNumber("1 + 3");
		assertThat(Calculator.calculate(input)).isEqualTo(4);
	}

	@Test
	void minus() {
		InputNumber input = new InputNumber("3 - 1");
		assertThat(Calculator.calculate(input)).isEqualTo(2);
	}

	@Test
	void times() {
		InputNumber input = new InputNumber("2 * 4");
		assertThat(Calculator.calculate(input)).isEqualTo(8);
	}

	@Test
	void divide() {
		InputNumber input = new InputNumber("4 / 2");
		assertThat(Calculator.calculate(input)).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈 연산을 하는 경우 분모가 0일때 IllegalArgumentException을 throw 한다")
	void divideByZero() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			InputNumber input = new InputNumber("4 / 0");
			Calculator.calculate(input);
		});
	}


	@Test
	@DisplayName("사칙연산 기호가 아닌경우 IllegalArgumentException을 throw 한다")
	void notOperandValueThrowsException() {
		assertThatThrownBy(() -> {
			InputNumber input = new InputNumber("1 ^ 4");
			Calculator.calculate(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 * 3 / 3 - 1:2"}, delimiter = ':')
	void allCalc(String input, double result) {
		InputNumber inputNumber = new InputNumber(input);
		assertThat(Calculator.calculate(inputNumber)).isEqualTo(result);
	}

}
