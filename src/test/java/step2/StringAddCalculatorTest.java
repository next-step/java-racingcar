package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
	private StringAddCalculator stringAddCalculator;

	@BeforeEach
	void setUp() {
		stringAddCalculator = new StringAddCalculator();
	}

	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = stringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = stringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}
}
