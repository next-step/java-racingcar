package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
	private StringAddCalculator stringAddCalculator;

	@BeforeEach
	void setUp() {
		stringAddCalculator = new StringAddCalculator();
	}

	@Test
	public void splitAndSum_null_또는_빈문자() {
		String[] inputs = stringAddCalculator.split(null);
		int result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(0);

		inputs = stringAddCalculator.split("");
		result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		String[] inputs = stringAddCalculator.split("1");
		int result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		String[] inputs = stringAddCalculator.split("1,2");
		int result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		String[] inputs =  stringAddCalculator.split("1,2:3");
		int result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		String[] inputs =  stringAddCalculator.split("//;\n1;2;3");
		int result = stringAddCalculator.sum(inputs);
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		String[] inputs = stringAddCalculator.split("-1,2,3");
		assertThatThrownBy(() -> stringAddCalculator.sum(inputs))
				.isInstanceOf(RuntimeException.class);
	}
}
