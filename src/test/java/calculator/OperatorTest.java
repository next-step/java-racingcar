package calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hspark on 02/11/2018.
 */
public class OperatorTest {
	@Test
	public void test_덧셈() {
		int result = Operator.findOperator("+").calculate(1, 2);
		Assertions.assertThat(result).isEqualTo(3);
	}

	@Test
	public void test_뺄셈() {
		int result = Operator.findOperator("-").calculate(1, 2);
		Assertions.assertThat(result).isEqualTo(-1);
	}

	@Test
	public void test_곱셈() {
		int result = Operator.findOperator("*").calculate(3, 2);
		Assertions.assertThat(result).isEqualTo(6);
	}

	@Test
	public void test_나눗셈() {
		int result = Operator.findOperator("/").calculate(4, 2);
		Assertions.assertThat(result).isEqualTo(2);
	}
}