package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void 덧셈() {
		int result = StringCalculator.calculate("2 + 3");
		assertThat(result).isEqualTo(5);
	}

	@Test
	public void 뺄셈() {
		int result = StringCalculator.calculate("5 - 3");
		assertThat(result).isEqualTo(2);
	}

	@Test
	public void 곱셈() {
		int result = StringCalculator.calculate("5 * 3");
		assertThat(result).isEqualTo(15);
	}

	@Test
	public void 나눗셈() {
		int result = StringCalculator.calculate("8 / 2");
		assertThat(result).isEqualTo(4);
	}

	@Test
	public void 연속_계산() {
		int result = StringCalculator.calculate("2 + 3 * 4");
		assertThat(result).isEqualTo(20);
	}

	@Test
	public void 연속_계산2() {
		int result = StringCalculator.calculate("2 + 3 * 4 / 2");
		assertThat(result).isEqualTo(10);
	}

	@Test
	public void 연속_계산3() {
		int result = StringCalculator.calculate("2 + 3 * 4 / 2 * 4 + 4 - 10");
		assertThat(result).isEqualTo(34);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_연산자() {
		StringCalculator.calculate("2 + 3 [ 4 / 2");
	}
}