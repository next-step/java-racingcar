package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class StringCalculatorTest {
	@Test
	public void test_덧셈() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("1 + 3");
		assertThat(result).isEqualTo(4);
	}

	@Test
	public void test_뺄셈() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("4 - 3");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void test_곱셈() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("4 * 3");
		assertThat(result).isEqualTo(12);
	}

	@Test
	public void test_나눗셈() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("4 / 2");
		assertThat(result).isEqualTo(2);
	}

	@Test
	public void test_복합계산() {
		StringCalculator stringCalculator = new StringCalculator();
		int result = stringCalculator.calculate("2 + 3 * 2 / 2");
		assertThat(result).isEqualTo(5);
	}
}