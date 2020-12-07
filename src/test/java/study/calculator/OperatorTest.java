package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

	@Test
	@DisplayName("덧셈 연산자 테스트")
	public void addition_test() throws Exception {
		//Given
		Addition addition = new Addition();
		//When
		int calculate = addition.calculate(1, 0);
		//Then
		assertThat(calculate).isEqualTo(1);
	}
}
