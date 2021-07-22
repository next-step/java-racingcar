package step2;

import static org.assertj.core.api.Assertions.*;
import static step2.Validator.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
	@Test
	void validateExpressionTest() {
		assertThatThrownBy(() -> validateExpression(" "))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력 값이 비어있어요!");
	}

	@Test
	void validateOperatorTest() {
		assertThatThrownBy(() -> validateOperator("&"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("연산 기호가 잘못됐어요!");
	}
}